package lab2;

import java.util.regex.Pattern;
/**
 * class "Assistant" with fields: termMonth, University.
 * @author User
 * @version 1.0
 */
public class Assistant extends Teacher {
    /** Field term of internship in month*/
    double termMonth;


    public Assistant() {
        super();
    };
    public Assistant(int age, String Lname, String Fname, int shift, int salary , String subject, double termMonth, int idS,int id) {
        super(age, Lname, Fname, shift,salary, subject,idS,id);
        this.termMonth = termMonth;
    }

    public double getTermMonth() {
        return termMonth;
    }

    public void setTermMonth(double termMonth) {
        this.termMonth = termMonth;
    }

    @Override
    public String toString() {
        return super.toString() + " Term of internship: " + termMonth ;
    }

}

