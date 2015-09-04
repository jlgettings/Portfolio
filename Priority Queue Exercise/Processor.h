/*FILE: Job.cpp (Assignment 4)
WRITTEN BY: Jessica Gettings (jgetting@spsu.edu)
Contains constructors, mutator and accessor functions, and a destructor
*/

#ifndef PROCESSOR_H
#define PROCESSOR_H
#include "Job.h"

class Processor
{
    public:
        //default constructor
        Processor();
        //overloaded constructor
        Processor(Job a);

        //mutator functions
        void setProcJob(Job a);
        //Precondition: A Processor object is instantiated
        //Postcondition: The Processor is reset using data from a Job object
        void countDown();
        //Precondition: A Job object is instantiated with duration > 0, and a Processor object is instantiated that takes the Job as a parameter
        //Postcondition: The cycleCount for that Processor is decremented by 1

        //accessor functions
        int getCount();
        //Precondition: A Processor object is instantiated with a Job object as a parameter
        //Postcondition: returns the cycleCount as an int

        virtual ~Processor();
    protected:
    private:
        int cycleCount;
};

#endif // PROCESSOR_H
