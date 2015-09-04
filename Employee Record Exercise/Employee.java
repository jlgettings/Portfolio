/*
Employee abstract class containing name and position variables, as well as methods
that are called in all subclasses.
 */

package assignment.pkg6;

/**
 *
 * @author Jessica Gettings
 */
public abstract class Employee {
    
    //instance variables for name and position, protected so subclasses can inherit them
    protected String name;
    protected String position;
    
    //default constructor, instantiates Employee object with null name and position
    public Employee(){
    }
    
    //overloaded constructor with two String parameters: name (n) and position(p)
    public Employee(String n, String p){
        name = n;
        position = p;
    }
    
    //sets name to String parameter n
    public void setName(String n){
        name = n;
    }
    //returns String name
    public String getName(){
        return name;
    }
    
    //sets position to String parameter p
    public void setPosition(String p){
        position = p;
    }
    //returns String position
    public String getPosition(){
        return position;
    }
    
    //abstract method returning amount the employee should be paid in a given week, accounting for tax withholding
    //returns wage as a double
    //will be overridden in all subclasses
    public abstract double weeklyWage();
    
    //abstract method returning employee's unused vacation days for the year, as an integer
    //will be overridden in all subclasses
    public abstract int vacationLeft();
    
    //overriding equals method, sets Employees to equal if they have the same name and position
    public boolean equals(Employee other){
        return this.name.equals(other.getName()) && this.position.equals(other.getPosition());
    }
    
    //overriding toString, prints name and position
    public String toString(){
        String s = ""+name+", "+position;
        return s;
    }

    //other setter methods called on subclasses in client file (see subclasses for summary)
    void setDays(int nextInt){}
    void setDaysTaken(int nextInt){}
    void setWage(double wage){}
    void setMarried(boolean married) {}
    void setSupervisor(String supervisor) {}
    void setHoursWorked(double worked) {}
    void setChildren(int children) {}

}
