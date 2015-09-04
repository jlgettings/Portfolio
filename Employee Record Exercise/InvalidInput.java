/*
 InvalidInput class handles exceptions due to an incomplete or incorrectly formatted text file, 
passing the wrong data type into a method, or passing an invalid parameter (e.g. a negative number of children).
 */

package assignment.pkg6;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Jessica Gettings
 */
public class InvalidInput extends Exception {
    
    //new scanner for manual corrections to input (scan2 to differentiate from scanner in client file)
    static Scanner scan2 = new Scanner(System.in);
    
    //default constructor - instantiates the exception as an object
    public InvalidInput(){  
    }
    
    //handles exceptions regarding number of employees (first line in text file)
    public int fixNumber(){
        boolean valid;      //tracks whether input is acceptable (re-prompt needed if not)
        int number;         //number of employees expected, needs to translate into number of indices in ArrayList workers
        
        System.out.println("File error: number of employees undetermined. "
                        + "Please manually enter the number of employees in the file: ");       //error message flagging invalid line in text file
                do{
                    valid = true;       //sets valid to true in expectation of valid manual input
                    try{
                        number = scan2.nextInt();           //scans manual input from user
                        if(number < 0){
                            valid = false;      //manual input is an invalid integer
                            System.out.println("File error: number of employees undetermined. "
                                + "Please manually enter the number of employees in the file: ");
                        }
                        else;
                    }
                    catch(InputMismatchException alsoNotInt){
                        valid = false;                  //manual input is wrong data type
                        System.out.println("Error: number of employees undetermined. "
                            + "Please manually enter the number of employees in the file: ");
                        number = 0;             //to prevent "variable may not have been initialized" error
                        scan2.nextLine();       //prepare for next input
                    }
                }while(valid==false);       //repeats until valid number is entered
                return number;          //returns valid number
    }
    
    //handles exceptions regarding position - wrong data type or position that does not match one of the available classes
    public String fixPosition(){
        boolean valid;          //tracks whether input is acceptable (re-prompt needed if not)
        String position;        //must be manager, hourly, temporary, or intern
        
        System.out.println("File error: Position expected. Please manually enter "      //error message flagging invalid data from text file
                + "one of the following positions: Manager, Hourly, Temporary, or Intern.");
                do{
                    valid = true;       //sets valid to true in expectation of valid manual input
                    try{
                        position = scan2.nextLine();           //scans manual input from user
                        if(!position.equals("Manager") && !position.equals("Hourly") 
                                && !position.equals("Temporary") && !position.equals("Intern")){
                            valid = false;          //input is an invalid String
                            System.out.println("Error: Position expected. "
                                + "Please manually enter one of the following positions: Manager, Hourly, Temporary, or Intern.");
                        }
                        else;
                    }
                    catch(InputMismatchException notString){
                        valid = false;      //input is the wrong data type
                        System.out.println("Error: Position expected. "
                                + "Please manually enter one of the following positions: Manager, Hourly, Temporary, or Intern.");
                        position = null;        //to prevent "variable may not have been initialized" error
                        scan2.nextLine();       //prepare for next input
                    }
                }while(valid==false);       //repeats until valid String is entered
                return position;            //returns valid String
    }
    
    //handles exceptions regarding employee name - wrong data type
    public String fixName(){
        boolean valid;      //tracks whether input is acceptable (re-prompt needed if not)
        String name;        //must be a String
        
        System.out.println("File error: Name expected. "                //error message flagging invalid data from text file
                        + "Please manually enter the name of the next employee.");
                do{
                    valid = true;       //sets valid to true
                    try{
                        name = scan2.nextLine();           //scans manual input from users
                    }
                    catch(InputMismatchException notString){
                        valid = false;          //manual input is the wrong data type
                        System.out.println("Error: Name expected. "
                        + "Please manually enter the name of the next employee.");
                        name = null;            //to prevent "variable may not have been initialized" error
                        scan2.nextLine();       //prepare for next input
                    }
                }while(valid==false);          //repeats until valid String is entered
                return name;        //returns valid String
    }
        
}
