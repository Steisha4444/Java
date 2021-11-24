package lab2;

import java.util.regex.Pattern;
/**
 * class "Teacher" with fields: Shift, salary, subject.
 * @author User
 * @version 1.0
 */
public class Teacher extends Worker {
    /** Shift field */
    protected int Shift;
    /** Subject field */
    protected  String subject;


    public Teacher() {
        super();
    };
    public Teacher(int age, String Lname, String Fname, int shift, int salary , String subject, int Sid, int id) {
        super(id,age, Lname, Fname,Sid,salary);
        this.Shift = shift ;
        this.salary = salary;
        this.subject = subject;
    }

    public int getShift() {
        return Shift;
    }
    public int getSalary() {
        return salary;
    }
    public String getSubject() {
        return subject;
    }
    public void setShift(int Shift) {
        this.Shift = Shift;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    /**
     * Overridden function of obtaining the hash code
     * @return returns the numeric value of the hash code
     */


    public String toString() {
        return super.toString() + " teacher position , Shift : " + Shift + " , subject is " + subject + " , salary is "  + salary  ;
    }


}
