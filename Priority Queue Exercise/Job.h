/*FILE: Job.cpp (Assignment 4)
WRITTEN BY: Jessica Gettings (jgetting@spsu.edu)
Contains constructors, a print function, accessor functions, an overloaded < operator, and a destructor
*/
#ifndef JOB_H
#define JOB_H

class Job
{
    public:
        //default constructor
        Job();
        //overloaded constructor
        Job(int id, int pr, int du);
        //Precondition: ID, priority, and duration parameters are provided
        //Postcondition: A Job objects is created using these parameters

        //print function for debugging purposes
        void printJob();
        //Precondition: A Job object is instantiated
        //Postcondition: The ID, priority, and duration of the job are printed

        //accessors
        int getID();
        //Precondition: Job object is instantiated
        //Postcondition: Job ID is returned as int
        int getPriority();
        //Precondition: Job object is instantiated
        //Postcondition: priority of job is returned as int
        int getDuration();
        //Precondition: Job object is instantiated
        //Postcondition: Job duration is returned as int

        //operator< overload
        bool operator<(Job a);
        //Precondition: A Job object is passed as a parameter
        //Postcondition: returns TRUE if the Job has a higher overall priority (lower priority and duration values)
            //than the Job making the call

        virtual ~Job();
    protected:
    private:
        int id, priority, duration;
};

#endif // JOB_H
