/*
Subclass of Hourly, describing temporary hourly workers. Temporary objects inherit name, position,
hourly wage, and vacation time (which is never used) from the Hourly class. The Temporary class 
implements the Married interface, and objects also contain information on spouse and children.
 */

package assignment.pkg6;

import java.text.DecimalFormat;

/**
 *
 * @author Jessica
 */
public class Temporary extends Hourly{

    DecimalFormat d = new DecimalFormat("#.00");        //for dollar amounts in toString
    
    //default constructor - name and position are null; wage, worked, and children are 0; married is false
    public Temporary(){
    }
    
    //overloaded constructor taking six parameters - all the same as the Hourly constructor parameters
    public Temporary(String name, String position, double wage, double worked,
             boolean married, int children){
        super(name, position, wage, worked, 0, 0, married, children);       //both vacation parameters hard-coded to 0
        days = 0;
        taken = 0;
    }
    
    //overriding setDays() from Hourly class to always be 0 for temporary employees
    public void setDays(int d){
        days = 0;
    }
    //overriding setDaysTaken() from Hourly class to always be 0 for temporary employees
    public void setDaysTaken(int t){
        taken = 0;
    }
    
    //wage setter and getter are inherited from Hourly, so are not repeated here
    
    //equals method inherited from Employee

    //overriding toString - does not call Hourly toString (because Hourly prints out vacation time)
    //prints name, position, wage, hours worked, marital status, and number of children
    public String toString(){
        String m;
        if(married)
            m = "married, ";
        else
            m = "not married, ";
        return ""+name+", "+position+", $"+d.format(wage)+" per hour, "+worked+" hours worked this week, "+m+
                children+" child(ren)";
    }
}
