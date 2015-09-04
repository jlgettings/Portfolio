/*FILE: Job.cpp (Assignment 4)
WRITTEN BY: Jessica Gettings (jgetting@spsu.edu)
See Job.h for documentation
*/

#include "Job.h"
#include <iostream>

Job::Job(){
}

Job::Job(int i, int p, int d){
    id = i;
    priority = p;
    duration = d;
}

int Job::getID(){
    return id;
}

int Job::getPriority(){
    return priority;
}

int Job::getDuration(){
    return duration;
}

bool Job::operator<(Job a){
    if(getPriority()!=a.getPriority()){
        return getPriority()<a.getPriority();
    }
    else{
        return getDuration()<a.getDuration();
    }
}

//for debugging
void Job::printJob(){

    std::cout << id << "\t" << priority << "\t" << duration << std::endl;
}

Job::~Job()
{
    //dtor
}
