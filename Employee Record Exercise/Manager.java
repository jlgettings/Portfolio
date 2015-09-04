/*
 Subclass of Employee, describing Managers. Managers objects inherit name and position
from the Employee class. They also have a yearly salary and vacation time. The Manager 
class implements the Married interface, and objects also contain information on spouse and children.
 */

package assignment.pkg6;

import java.text.DecimalFormat;

/**
 *
 * @author Jessica Gettings
 */
public class Manager extends Employee implements Married{
    
    //instance variables
    private double salary;      //pay for an entire year
    private int days;           //total vacation days given
    private int taken;          //vacation days taken in the current year so far
    private boolean married;    //true if manager is married
    private int children;       //number of children
    
    DecimalFormat d = new DecimalFormat("#.00");        //format for dollar amounts in toString
    
    //default constructor - name and position are null; days, taken and children are 0.0; married is false
    public Manager(){
    }
    
    //overloaded constructor taking seven parameters - name, position, and one for each instance variable listed above
    public Manager(String name, String position, double salary, int days, int taken, boolean married, int children){
        super(name, position);
        this.salary = salary;
        this.days = days;
        this.taken = taken;
        this.married = married;
        this.children = children;
    }
    
    //sets salary for year as double s
    public void setWage(double s){
        salary = s;
    }
    //returns double salary
    public double getSalary(){
        return salary;
    }
    
    //sets vacation days for the year as int d
    public void setDays(int d){
        days = d;
    }
    //returns int vacation days for the year
    public int getDays(){
        return days;
    }
    
    //sets vacation days taken in the current year so far as int t
    public void setDaysTaken(int t){
        taken = t;
    }
    //returns int vacation days taken in the current year so far
    public int getDaysTaken(){
        return taken;
    }
    
    //overrides vacationLeft from Employee class, returns int vacation days remaining
    public int vacationLeft(){
        int d = getDays() - getDaysTaken();
        if(d < 0){
            System.out.println("ERROR: Too much vacation taken.");
        }
        else;
        return d;
    }
    
    //overrides weeklyWages from Employee class, returns double amount to be paid in current week (accounting for taxes)
    public double weeklyWage(){
        double withheld = 500 - calcDeduct();       //amount withheld for taxes
        if(salary/52 > withheld)
            return salary/52 - withheld;       //yearly salary divided by weeks per year, minus withholding
        else
            return salary/52;
    }
    
    //sets marital status as boolean m (true if married)
    public void setMarried(boolean m){
        married = m;
    }
    //returns boolean married (marital status - true if married)
    public boolean getMarried(){
        return married;
    }
    
    //sets number of children as int c
    public void setChildren(int c){
        children = c;
    }
    //returns int children (number of children)
    public int getChildren(){
        return children;
    }
    
    //override calcDeduct - calculates amount to be deducted from this week's tax withholding
    public int calcDeduct(){
        int deduct = 0;
        if(married)
            deduct += DEDUCTION;        //$100 for spouse (see Married class)
        else;
        deduct += DEDUCTION * children;     //$100 per child (see Married class)
        if(deduct < MAXDEDUCTION)
            return deduct;
        else
            return MAXDEDUCTION;        //$500 max
    }
    
    //equals method inherited from Employee without change
    
    //overrides toString - prints salary, vacation, marital status, and children in addition to name and position
    public String toString(){
        String m;
        if(married)
            m = "married, ";
        else
            m = "not married, ";
        return super.toString()+", $"+d.format(salary)+" per year, "+days+
                " vacation days per year, "+taken+" vacation day(s) taken, "+m+
                children+" child(ren)";
    }
    
}
