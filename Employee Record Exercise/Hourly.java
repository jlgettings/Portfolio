/*
 Subclass of Employee, describing hourly workers. Hourly objects inherit name and position
from the Employee class. They also have an hourly wage, overtime, and vacation time. The Hourly 
class implements the Married interface, and objects also contain information on spouse and children.
 */

package assignment.pkg6;

import java.text.DecimalFormat;

/**
 *
 * @author Jessica Gettings
 */
public class Hourly extends Employee implements Married{
 
    //instance variables, protected so Temporary can inherit them
    protected double wage;          //pay per hour
    protected double worked;        //hours worked per week
    protected int days;             //vacation days per year
    protected int taken;            //vacation days taken in the current year
    protected boolean married;      //true if employee is married
    protected int children;         //number of children
    
    DecimalFormat d = new DecimalFormat("#.00");        //format for dollar amounts in toString
    
    //default constructor - name and position are null; wage, worked, days, taken, and children are 0; married is false
    public Hourly(){
    }
    
    //overloaded constructor taking eight parameters - name, position, and one for each of the six instance variables above
    public Hourly(String name, String position, double wage, double worked, int days, int taken, boolean married, int children){
        super(name, position);
        this.wage = wage;
        this.worked = worked;
        this.days = days;
        this.taken = taken;
        this.married = married;
        this.children = children;
    }
    
    //sets hourly wage as double w
    public void setWage(double w){
        wage = w;
    }
    //returns double wage (per hour)
    public double getWage(){
        return wage;
    }
    
    //sets hours worked in the current week as double w
    public void setHoursWorked(double w){
        worked = w;
    }
    //returns double worked (hours worked in the current week)
    public double getHoursWorked(){
        return worked;
    }
    
    //sets total vacation days for the current year as int d
    public void setDays(int d){
        days = d;
    }
    //returns int days (total vacation days for the current year)
    public int getDays(){
        return days;
    }
    
    //sets vacation days taken in the current year as int t
    public void setDaysTaken(int t){
        taken = t;
    }
    //returns int taken (vacation days taken in the current year)
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
        double weeklyPay;               //pay per week, originally before withholding
        double withheld = 500 - calcDeduct();
        if(getHoursWorked()>40){
            double overtime = getHoursWorked() - 40;        //everything past 40 hours a week is overtime
            weeklyPay = 40*getWage() + overtime*1.5*getWage();      //1.5x pay for overtime, plus regular pay for 40 hours
        }
        else
            weeklyPay = getHoursWorked()*getWage();
        if(weeklyPay > withheld)
            return weeklyPay - withheld;        //pay is adjusted for taxes
        else
            return weeklyPay;
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
            deduct += DEDUCTION;
        else;
        deduct += DEDUCTION * children;
        if(deduct < MAXDEDUCTION)
            return deduct;
        else
            return MAXDEDUCTION;
    }
    
    //equals method inherited from Employee
    
    //overrides toString - prints wage, hours worked, vacation, marital status, and children in addition to name and position
    public String toString(){
        String m;
        if(married)
            m = "married, ";
        else
            m = "not married, ";
        return super.toString()+", $"+d.format(wage)+" per hour, "+worked+" hours worked this week, "+days+
                " vacation days per year, "+taken+" vacation day(s) taken, "+m+
                children+" child(ren)";
    }

     
}
    
