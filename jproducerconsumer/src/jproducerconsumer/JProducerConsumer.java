package jproducerconsumer;

/*Using two threads and synchronized methods, prints numbers 1 to ITER 
 *in order with no skips or duplicates*/

import java.util.Random;

public class JProducerConsumer {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int ITER = 10; 	//number of iterations, must be same for both threads
						//or else the longer one will hang at the end
		
		Value v = new Value();
		
		Producer p = new Producer(v, ITER);
		Consumer c = new Consumer(v, ITER);
		
		p.start();
		c.start();
	}
}

class Value {
	
	int valueP;		//value that the producer updates
	int valueC;		//valueP copied here by consumer and stored until it can be printed
					//(consumer is synchronized, but print statement is not)
	boolean ready;	//whether or not valueP has been updated and is ready for the consumer
	
	public Value(){
		/*constructor*/
		valueP = 0;
		valueC = 0;
		ready = false;
	}
	
	public synchronized void incValue(){
		
		while(ready){
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		valueP++;
		ready = true;

		notifyAll();
	}
	
	public synchronized void consumeValue(){
		
		while(!ready){
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		valueC = valueP;
		
		ready = false;
		
		notifyAll();
	}
	
	public int getValue(){
		return valueC;
	}
	
}

class Producer extends Thread {
	
	Value v;
	int it;
	
	public Producer(Value v, int it){
		/*constructor*/
		this.v = v;
		this.it = it;
	}

	public void run(){
		
		final Random r = new Random();
		
		for(int i=0; i<it; i++){
			
			v.incValue();

			try {
				sleep(r.nextInt(500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
}

class Consumer extends Thread {
	
	Value v;
	int it;
	
	public Consumer(Value v, int it){
		/*constructor*/
		this.v = v;
		this.it = it;		
	}
	
	public void run(){
		
		final Random r = new Random();
		
		for(int i=0; i<it; i++){	
			
			v.consumeValue();
			
			try {
				sleep(r.nextInt(500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(v.getValue());
		}
	}
}
