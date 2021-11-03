package lab2;

import java.time.LocalDate;
import java.util.regex.Pattern;

import java.io.*;
/**
 * class "Worker" with fields: id, firstName,lastName , age , email, position.
 * @author User
 * @version 1.0
 */
public class Worker implements Comparable<Worker>{


    protected String firstName;

    protected String lastName;

    protected int age;


    protected String position = "worker";

    public Worker () {};
    public Worker (int age, String Lname, String Fname) {
        if (age > 0)
            this.age = age;

        this.lastName = Lname;
        this.firstName = Fname;
    }

    public int getAge() {
        return age;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public Worker get() {
        return this;
    }

    public void setAge(int age) {
        if (age > 0)
            this.age = age;
    }
    public void setLastName(String Lname) {
        this.lastName = Lname;

    }
    public void setFirstNameName(String name) {
        this.firstName = name;
    }



    @Override
    public String toString() {
        return firstName  +  "  " + lastName+ ", " + age + " years, "  + position;
    }


    @Override
    public int compareTo( Worker a) {
        if (age == a.age) {
            if (lastName.length() == a.lastName.length()) {
                if (firstName.length() == a.firstName.length()) {
                    return firstName.compareTo(a.firstName);
                }
                return firstName.length() - a.firstName.length();
            }
            return lastName.length() - a.lastName.length();
        }
        return age - a.age;
    }


}
