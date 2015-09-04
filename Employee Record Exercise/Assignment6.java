/*
 * Client file - first tests individual getter and setter methods for Employee subclasses,
 * then reads Employee data from a file, calculates vacation and tax withholding, and prints output
 */

package assignment.pkg6;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Jessica Gettings
 */
public class Assignment6 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        //instantiate text file object
        File input = new File("C:\\Users\\Jessica\\Documents\\NetBeansProjects\\Assignment 6\\src\\assignment\\pkg6\\employeeData.txt");
        
        //instantiate scanner for reading from file
        Scanner scan = new Scanner(input);
       
        //decimal format for dollar amounts
        DecimalFormat dec = new DecimalFormat("#.00");
        
        //other instance variables - initialized to default values in case of errors
        
        int number = 0;             //number of employees in file
        String position = null;     //type of employee
        String name = null;         //employee name
        double wage = 0;            //employee wages--may be yearly, hourly, or weekly depending on employee type
        String spouse;              //y/n input for marriage, read from file
        boolean married = false;    //spouse value converted to true or false
        int children = 0;           //number of children
        String temp = null;         //temporary placeholder for saving next employee position, in case of error reading file
        

        //CODE FOR TESTING INDIVIDUAL METHODS
 /*     //test Manager default constructor and setters/getters
        Manager m1 = new Manager();
        m1.setName("Alistair Lethbridge-Stewart");
        System.out.println(m1.getName());
        m1.setPosition("Manager");
        System.out.println(m1.getPosition());
        m1.setWage(100000);
        System.out.println(m1.getSalary());
        m1.setDays(15);
        System.out.print(m1.getDays());
        m1.setDaysTaken(0);
        System.out.println(", "+m1.getDaysTaken());
        m1.setMarried(true);
        System.out.println(m1.getMarried());
        m1.setChildren(1);
        System.out.println(m1.getChildren());
        System.out.println(dec.format(m1.weeklyWage()));
        System.out.println(m1.vacationLeft());
                
        //test Manager overloaded constructor
        Manager m2 = new Manager("Jack Harkness", "Manager", 120000, 10, 0, false, 1);
        System.out.println(m2);
        System.out.println(dec.format(m2.weeklyWage()));
        System.out.println(m2.vacationLeft());

        
        //test Hourly default constructor and setters/getters
        Hourly h1 = new Hourly();
        h1.setName("Amy Pond");
        System.out.println(h1.getName());
        h1.setPosition("Hourly");
        System.out.println(h1.getPosition());
        h1.setWage(25);
        System.out.println(h1.getWage());
        h1.setHoursWorked(35);
        System.out.println(h1.getHoursWorked());
        h1.setDays(10);
        System.out.print(h1.getDays());
        h1.setDaysTaken(6);
        System.out.println(", "+h1.getDaysTaken());
        h1.setMarried(true);
        System.out.println(h1.getMarried());
        h1.setChildren(2);
        System.out.println(h1.getChildren());
        System.out.println(dec.format(h1.weeklyWage()));
        System.out.println(h1.vacationLeft());
        
        //test Hourly overloaded constructor
        Hourly h2 = new Hourly("Rory Williams", "Hourly", 20, 30, 10, 8, true, 2);
        System.out.println(h2);  
        System.out.println(dec.format(h2.weeklyWage()));
        System.out.println(h2.vacationLeft());
        
        
        //test Temporary default constructor and setters/getters
        Temporary t1 = new Temporary();
        t1.setName("Donna Noble");
        System.out.println(t1.getName());
        t1.setPosition("Temporary");
        System.out.println(t1.getPosition());
        t1.setWage(25);
        System.out.println(t1.getWage());
        t1.setHoursWorked(35);
        System.out.println(t1.getHoursWorked());
        t1.setDays(10);             //making sure vacation is overwritten to 0
        System.out.print(t1.getDays());
        t1.setDaysTaken(6);
        System.out.println(", "+t1.getDaysTaken());
        t1.setMarried(false);
        System.out.println(t1.getMarried());
        t1.setChildren(0);
        System.out.println(t1.getChildren());
        System.out.println(dec.format(t1.weeklyWage()));
        System.out.println(t1.vacationLeft());
        //test Temporary overloaded constructor
        Temporary t2 = new Temporary("River Song", "Temporary", 35, 40, true, 0);
        System.out.println(t2); 
        System.out.println(dec.format(t2.weeklyWage()));
        System.out.println(t2.vacationLeft());
        

        //test Intern default constructor and setters/getters
        Intern i1 = new Intern();
        i1.setName("Clara Oswald");
        System.out.println(i1.getName());
        i1.setPosition("Intern");
        System.out.println(i1.getPosition());
        i1.setWage(400);
        System.out.println(i1.getWage());
        i1.setSupervisor("Ian Chesterton");
        System.out.println(i1.getSupervisor());
        i1.setMarried(false);
        System.out.println(i1.getMarried());
        i1.setChildren(2);
        System.out.println(i1.getChildren());
        System.out.println(i1.weeklyWage());
        System.out.println(i1.vacationLeft());
                
        //test Intern overloaded constructor
        Intern i2 = new Intern("Strax", "Intern", 100, "Vastra", false, 0);
        System.out.println(i2); 
        System.out.println(i2.weeklyWage());
        System.out.println(i2.vacationLeft());

     */   
        
        //read number of employees from data file
        try{
            number = scan.nextInt();
            if(number < 0){             //treats negative numbers as invalid, because they will cause errors in the ArrayList later
                InvalidInput error = new InvalidInput();
                number = error.fixNumber();
            }   
            else;  
        }
            catch(InputMismatchException notInt){           //if the first line is not an integer
                InvalidInput error = new InvalidInput();
                number = error.fixNumber();
            }
            catch(NoSuchElementException empty){            //if entire file is blank
                System.out.println("Input file is empty. Please correct the input file.");
                return;             //ends program without reading anything
            }

        //create Employee array
        ArrayList<Employee> workers = new ArrayList<Employee>(number);

        try{                   //catches error in which number of employees expected is greater than number in file
            for(int i=0; i<number; i++){            //establish loop for each employee
                            
                try{           //catching exceptions for position here, because position is required for if-statements
                    if(temp != null){       //used if previous employee caused an error (see catch block below)
                        position = temp;
                        temp = null;
                    }
                    else{           //if previous employee did not cause an error
                        scan.nextLine();        //ignore line end marker after reading an int (first line or children of previous employee)
                        position = scan.nextLine();
                        if(!position.equals("Manager") && !position.equals("Hourly") 
                                    && !position.equals("Temporary") && !position.equals("Intern")){        //position must be the same as a class name
                            InvalidInput error = new InvalidInput();
                            position = error.fixPosition();         //calls method to enter a new position
                        }
                        else;
                    }
                }
                catch(InputMismatchException notString){
                    InvalidInput error = new InvalidInput();
                    position = error.fixPosition();             //calls method to enter a new position
               }
                
                try{                //catching exceptions for name in their own block, because I want to use name in a later error message
                    name = scan.nextLine();
                }
                catch(InputMismatchException notString){
                    InvalidInput error = new InvalidInput();
                    name = error.fixName();             //calls method to enter a new name
                }
                
                try{                    //wage needs its own block because an exception here will prevent the ArrayList index from being initialized
                    wage = scan.nextDouble();
                    scan.nextLine();        //ignores end of line after reading double
                }
                catch(InputMismatchException notDouble){
                    InvalidInput error = new InvalidInput();
                    System.out.println("ERROR: Wage input for \""+name+"\" is invalid. Wage has been set to 0. Please correct the input file.\n");
                    wage = 0;
                    scan.nextLine();
                }
                try{            //exceptions for remaining variables are lumped together
                    if(position.equalsIgnoreCase("Manager")){       //manager gets vacation days and days taken
                        workers.add(new Manager());                 //create new manager in ArrayList
                        workers.get(i).setDays(scan.nextInt());         //set manager-specific parameters to current ArrayList index
                        workers.get(i).setDaysTaken(scan.nextInt());
                        scan.nextLine();
                    }
                    else if(position.equalsIgnoreCase("Hourly")){       //hourly gets hours worked, vacation days and days taken
                        workers.add(new Hourly());                  //new hourly employee in ArrayList
                        workers.get(i).setHoursWorked(scan.nextDouble());   //set hourly-specific parameters to current ArrayList index
                        scan.nextLine();                //ignores end of line after reading double
                        workers.get(i).setDays(scan.nextInt());
                        workers.get(i).setDaysTaken(scan.nextInt());
                        scan.nextLine();            //ignores end of line after reading int

                    }
                    else if(position.equalsIgnoreCase("Temporary")){        //temporary gets hours worked but no vacation
                        workers.add(new Temporary());           //new temporary employee in ArrayList
                        workers.get(i).setHoursWorked(scan.nextDouble());      //set hours worked to current ArrayList index
                        scan.nextLine();            //ignores end of line after reading double

                    }
                    else if(position.equalsIgnoreCase("Intern")){           //intern gets supervisor but no vacation
                        workers.add(new Intern());                  //new intern employee in ArrayList
                        workers.get(i).setSupervisor(scan.nextLine());      //set supervisor to current ArrayList index
                    }
                    else;
                    
                    spouse = scan.nextLine();               //reads "y" or "n" from file, same for all classes
                    if(spouse.equalsIgnoreCase("y"))        //converts from y/n to boolean
                        married = true;
                    else if(spouse.equalsIgnoreCase("n"))
                        married = false;
                    else{
                        System.out.println("ERROR: Invalid marriage data. Employee \""+
                                name+"\" is assumed to be \"not married\" for tax purposes. Please correct input file.");
                        married = false;
                   }
                    
                    children = scan.nextInt();          //same for all classes
                    
                    //set all remaining parameters in current iteration of the loop to the current ArrayList index
                    workers.get(i).setName(name);
                    workers.get(i).setPosition(position);
                    workers.get(i).setWage(wage);
                    workers.get(i).setMarried(married);
                    workers.get(i).setChildren(children);

                    System.out.println(workers.get(i));     //print toString of employee at current index
                    
                    if(children < 0){       //number of children must be 0 or positive
                        System.out.println("ERROR: An employee cannot have "
                                + "negative children. Tax deduction is based on 0 children. Please correct the input file.");
                        workers.get(i).setChildren(0);
                    }
                    else;
                    
                    //print results of weeklyWage and vacationLeft
                    System.out.println("Take-home pay this week: $"+dec.format(workers.get(i).weeklyWage())
                            +", Vacation days left: "+workers.get(i).vacationLeft()+"\n");
                }
                
                //message for wrong input type for parameters other than position and name
                catch(InputMismatchException wrongInput){
                    System.out.println("\nERROR: The input data for \""+name+"\" is not valid. Please correct the input file. \n");
                   
                    //recovering from wrong input type error
                    do{
                        temp = scan.nextLine();                 //temporarily saves next value in the file, repeats until it finds a position
                      }while(!temp.equals("Manager") && !temp.equals("Hourly") 
                                && !temp.equals("Temporary") && !temp.equals("Intern"));    //breaks the loop when it reaches a position, and saves that position for next loop iteration
                }
            }
        }
        //message for if data is missing from the end of the file (or if the number given in the first line of the file was too large)
        catch(NoSuchElementException fileEnds){
                System.out.println("Less data than expected. Please correct the input file.");
        }
        
    } 
}
