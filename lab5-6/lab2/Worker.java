package lab2;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.time.LocalDate;
import java.util.regex.Pattern;

import java.io.*;

/**
 * class "Worker" with fields: id, firstName,lastName , age , email, position.
 *
 * @author User
 * @version 1.0
 */
public class Worker {

    protected int id;

    protected String firstName;

    protected String lastName;

    protected int age;

    protected int salary;

    protected int SchoolId;


    protected String position = "worker";

    public Worker() {
    }

    ;

    public Worker(int id, int age, String Lname, String Fname, int SId, int salary) {
        if (age > 0)
            this.age = age;
        this.id = id;
        this.SchoolId = SId;
        this.lastName = Lname;
        this.firstName = Fname;
        this.salary = salary;
    }


    public int getId() {
        return id;
    }

    public int getSchoolId() {
        return SchoolId;
    }

    public int getSalary() {
        return salary;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setSchoolId(int id) {
        this.SchoolId = id;
    }

    public void setAge(int age) {
        if (age > 0)
            this.age = age;
    }

    public void setLastName(String Lname) {
        this.lastName = Lname;

    }

    public void setFirstName(String name) {
        this.firstName = name;
    }


    @Override
    public String toString() {
        return "id = " + id + " " + firstName + "  " + lastName + ", " + age + " years , " + salary+ "$ , " + " " +  SchoolId + " " + position;
    }




}




