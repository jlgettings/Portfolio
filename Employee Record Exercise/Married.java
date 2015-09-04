/*
 Interface providing abstract methods for obtaining marital status and number of children,
and for using that information to calculate tax deductions.
 */

package assignment.pkg6;

/**
 *
 * @author Jessica Gettings
 */
public interface Married {
    
    //final variables
    int DEDUCTION = 100;        //deduction per family member (spouse or child)
    int MAXDEDUCTION = 500;     //maximum total deduction
    
    //abstract married setter method
    public abstract void setMarried(boolean m);
    //abstrac married getter method
    public abstract boolean getMarried();
    
    //abstract children setter method
    public abstract void setChildren(int c);
    //abstract children getter method
    public abstract int getChildren();
    
    //abstract calcDeduct method
    public abstract int calcDeduct();
    
}
