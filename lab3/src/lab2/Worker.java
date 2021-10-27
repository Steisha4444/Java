package lab2;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.regex.Pattern;

import java.io.*;
/**
 * class "Worker" with fields: id, firstName,lastName , age , email, position.
 * @author User
 * @version 1.0
 */
public class Worker implements Serializable{

    @JsonProperty("FirstName")
    protected String firstName;
    @JsonProperty("LastNane")
    protected String lastName;
    @JsonProperty("Age")
    protected int age;

    @JsonProperty("position")
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

    public void setAge(int age) {
        if (age > 0)
            this.age = age;
    }
    public void setLastName(String Lname) {
        this.lastName = Lname;

    }
    public void setFirstName (String name) {
        this.firstName = name;
    }


    /**
     *  Overriden function of obtaining a string representation of
     *  an instance of a class "Worker"
     *  @return returns the string representation
     */
    @Override
    public String toString() {
        return  "FirstName = " + firstName  +  " LastName = " + lastName+ " "+  age + " years, "  + position + "\n";
    }


}
