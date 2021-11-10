package lab2;

import java.time.LocalDate;
import java.util.regex.Pattern;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.*;
import java.util.Set;
/**
 * class "Worker" with fields: id, firstName,lastName , age , email, position.
 * @author User
 * @version 1.0
 */
public class Worker{

    /** Unique identifier field */
    @NotNull
    protected int id;

    /** First Name field */

    @Size(min=2, max = 20, message = "First Name must be more than 2 character")
    protected String firstName;

    /** Last Name field */
    @Size(min=1, max = 20, message = "Last Name must be more than 2 character")
    protected String lastName;

    /** Age field */
    @Min(value = 18, message = "Age cannot be less than 18")
    @Max(value = 60, message = "Age cannot be more than 60")
    protected int age;

    /** Email field */
    @NotNull(message = "must be not null")
    protected String email;

    /** Position field */
    @NotNull(message = "must be not null")
    protected String position = "worker";


    protected Worker(){};
    /**
     * Overridden function of obtaining the hash code
     * @return returns the numeric value of the hash code
     */
    @Override
    public int hashCode() {
        final int prime = 27;
        int result = 1;
        result = prime * result + age;
        result = prime * result + firstName.length();
        result = prime * result + lastName.length();
        result = prime * result + email.length();
        result = prime * result + position.length();
        return result;

    }
    /**
     * Overridden function of comparison an instance of
     * the class "Worker" and an instance of the class "Object"
     * @return returns the boolean value of the comparison
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.hashCode() != obj.hashCode())
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        Worker temp = (Worker) obj;
        if(this.firstName != temp.firstName || this.lastName != temp.lastName || this.age != temp.age || this.email != temp.email || this.position != temp.position)
            return false;
        return true;
    }
    /**
     *  Overriden function of obtaining a string representation of
     *  an instance of a class "Worker"
     *  @return returns the string representation
     */
    @Override
    public String toString() {
        return firstName  +  " " + lastName+ ", " + age + " years, email:  " + email + " , " + position;
    }
    /**
     * Class "Builder" with fields: newWorker, Count
     * @author User
     * @version 1.0
     */
    public static class Builder {

        /**
         * worker field
         */
        private Worker newWorker;
        /**
         * Count of workers field
         */
        private static int Count = 0;

        /**
         * Constructor - creating a new object
         *
         * @see Builder#Builder()
         */
        public Builder() {
            newWorker = new Worker();
        }

        /**
         * Function  Last name designition
         * @param name - Last name of a worker
         * @return returns current object
         */
        public Builder addLastName(String name) {
            if (!name.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("Name must contain only letters");
            }
            newWorker.lastName = name;
            return this;
        }
        /**
         * Function First name designition
         * @param name - First name of a worker
         * @return returns current object
         */
        public Builder addFirstName(String name){
            if (!name.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("Name must start with capital letter");
            }
            newWorker.firstName= name;
            return this;
        }
        /**
         * Function age designition
         * @param age - age of a worker
         * @return returns current object
         */
        public Builder addAge(int age){
            if (age > 18) {
                newWorker.age = age;
            } else {
                throw new IllegalArgumentException("Age cannot be less than 18");
            }
            return this;
        }
        /**
         * Function email designition
         * @param email - email of a worker
         * @return returns current object
         * @throws IllegalArgumentException - if the email address isn't valid
         */
        public Builder addEmail(String email){
            Pattern p = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
            if (p.matcher(email).matches())
                newWorker.email = email;
            else
                throw new IllegalArgumentException("Illegal Argument");
            return this;
        }
        /**
         * Function of creating an object of class "Worker"
         * @return returns new object of class "Worker"
         */
        public Worker Build() {
            newWorker.id = ++Count;
            return newWorker;
        }
    }


    public int getAge() {
        return age;
    }
    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }



    public static void main(String args[]){
        try {
            Worker worker = new Worker.Builder()
                    .addLastName("Petrenko")
                    .addFirstName("Petro")
                    .addAge(19)
                    .addEmail("p.petro@gmail.com")
                    .Build();

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}