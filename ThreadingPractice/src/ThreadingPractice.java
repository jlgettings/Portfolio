/*Basic threading in Java*/

import java.util.Random;

public class ThreadingPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SampleThread1 s1 = new SampleThread1();
		SampleThread2 s2 = new SampleThread2();
		
		s1.start();
		s2.start();
	}

}

class SampleThread1 extends Thread {
	public SampleThread1(){
		/*constructor*/
	}

	public void run(){
		final Random r = new Random();
		
		for(int i=0; i<10; i++){
			System.out.println("Running SampleThread1");
			
			try {
				sleep(r.nextInt(100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
}

class SampleThread2 extends Thread {
	public SampleThread2(){
		/*constructor*/
	}
	
	public void run(){
		final Random r = new Random();
		
		for(int i=0; i<10; i++){
			System.out.println("Running SampleThread2");
			
			try {
				sleep(r.nextInt(100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
