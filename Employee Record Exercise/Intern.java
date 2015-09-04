/*
 Subclass of Employee, describing interns. Interns inherit name and position
from the Employee class. They have a flat weekly wage and no vacation. The Hourly 
class implements the Married interface, and objects also contain information on spouse and children.
 */

package assignment.pkg6;

import java.text.DecimalFormat;

/**
 *
 * @author Jessica
 */
public class Intern extends Employee implements Married{
    
    //instance variables
    private double wage;            //flat wage per week
    private String supervisor;      //name of supervisor
    private boolean married;        //true if intern is married
    private int children;           //number of children
    
    DecimalFormat d = new DecimalFormat("#.00");
    
    //default constructor - name, position, and supervisor are null; wage and children are 0; married is false
    public Intern(){
    }
    
    //overloaded constructor taking six parameters - name, position, and the four given above
    public Intern(String name, String position, double wage, String supervisor, boolean married, int children){
        super(name, position);
        this.wage = wage;
        this.supervisor = supervisor;
        this.married = married;
        this.children = children;
    }
    
    //sets weekly wage as double w
    public void setWage(double w){
        wage = w;
    }
    //returns double wage (weekly flat wage, before withholding is taken into account)
    public double getWage(){
        return wage;
    }
    
    //sets supervisor as String s
    public void setSupervisor(String s){
        supervisor = s;
    }
    //returns String supervisor
    public String getSupervisor(){
        return supervisor;
    }
    
    //overrides weeklyWages from Employee class, returns double amount to be paid in current week (accounting for taxes)
    public double weeklyWage(){
        double withheld = 500 - calcDeduct();
        if(wage > withheld)
            return wage - withheld;
        else
            return wage;
    }
    
    //overrides vacationLeft, hard-codes to 0 because interns don't get vacation
    public int vacationLeft(){
        return 0;
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
    
    //overrides toString - prints wage, supervisor, marital status and children in addition to name and position
    public String toString(){
        String m;
        if(married)
            m = "married, ";
        else
            m = "not married, ";
        return super.toString()+", $"+d.format(wage)+" per week, supervised by "+supervisor+", "+m+
                children+" child(ren)";
    }
}
