/*FILE: main.cpp (Assignment 4)
WRITTEN BY: Jessica Gettings (jgetting@spsu.edu)
Includes main driver file.
*/

#include <iostream>
#include <fstream>
#include "Job.h"
#include <deque>
#include <algorithm>
#include "Processor.h"

using namespace std;

int main()
{
    //open and read file
    ifstream input;
    int i, p, d;            //temporary variables for ID, priority, and duration
    deque<Job> waitlist;    //vector of Job objects in order of ID

    input.open("data.txt");
    if(input.is_open()){
        while(!input.eof()){
            input >> i >> p >> d;
            waitlist.push_back(Job(i, p, d));
        }
        input.close();
    }
    else{
        cout << "Cannot read file." << endl;
    }

    //heapify and sort data
    make_heap(waitlist.begin(), waitlist.end());
    sort_heap(waitlist.begin(), waitlist.end());

    //"machine" with four processors
    Processor p1, p2, p3, p4;
    Job j1, j2, j3, j4;     //variables designated job currently assigned to each processor

    cout << "Processor: \t 1 \t 2 \t 3 \t 4" << endl;

    //repeat loop until all jobs have been popped from waitlist AND all cycles have been run for each job
    while(!waitlist.empty()|| p1.getCount()!=0 || p2.getCount()!=0 || p3.getCount()!=0 || p4.getCount()!=0){
        //if a current job is complete AND jobs still exist in the waitlist, load next job from waitlist into available processor
        if(p1.getCount()==0 && !waitlist.empty()){
            j1 = waitlist.front();
            waitlist.pop_front();
            p1.setProcJob(j1);
        }
        if(p2.getCount()==0 && !waitlist.empty()){
            j2 = waitlist.front();
            waitlist.pop_front();
            p2.setProcJob(j2);
        }
        if(p3.getCount()==0 && !waitlist.empty()){
            j3 = waitlist.front();
            waitlist.pop_front();
            p3.setProcJob(j3);
        }
        if(p4.getCount()==0 && !waitlist.empty()){
            j4 = waitlist.front();
            waitlist.pop_front();
            p4.setProcJob(j4);
        }
        //if job in processor is not complete, print current cycle and decrement cycle count
        if(p1.getCount()>0){
            cout << "\t\t" << j1.getID() << ":" << p1.getCount() << "\t";
            p1.countDown();
        }else{
            cout << "\t\t\t";
        }
        if(p2.getCount()>0){
            cout << j2.getID() << ":" << p2.getCount() << "\t";
            p2.countDown();
        }else{
            cout << "\t";
        }
        if(p3.getCount()>0){
            cout << j3.getID() << ":" << p3.getCount() << "\t";
            p3.countDown();
        }else{
            cout << "\t";
        }
        if(p4.getCount()>0){
            cout << j4.getID() << ":" << p4.getCount() << endl;
            p4.countDown();
        }else{
            cout << "\t";
        }
    }

}
