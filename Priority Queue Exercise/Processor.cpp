/*FILE: Job.cpp (Assignment 4)
WRITTEN BY: Jessica Gettings (jgetting@spsu.edu)
See Processor.h for documentation.
*/

#include "Processor.h"

Processor::Processor(){
    cycleCount = 0;     //default value
}

Processor::Processor(Job a){
    cycleCount = a.getDuration();
}

void Processor::setProcJob(Job a){
    cycleCount = a.getDuration();
}

void Processor::countDown(){
    cycleCount = cycleCount - 1;
}

int Processor::getCount(){
    return cycleCount;
}

Processor::~Processor()
{
    //dtor
}
