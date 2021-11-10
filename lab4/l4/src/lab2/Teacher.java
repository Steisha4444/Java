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
    /** Salary field */
    protected  int salary;
    /** Subject field */
    protected  String subject;
    protected    Teacher(){};
    /**
     * Overridden function of obtaining the hash code
     * @return returns the numeric value of the hash code
     */

    @Override
    public int hashCode() {
        final int prime = 33;
        int result = super.hashCode();
        result = prime * result + salary;
        result = prime * result + subject.length();
        return result;

    }
    /**
     * Overridden function of comparison an instance of
     *  the class "Teacher" and an instance of the class "Object"
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
        Teacher temp = (Teacher)obj;
        if(this.firstName != temp.firstName || this.lastName != temp.lastName || this.age != temp.age ||
                this.email!= temp.email ||    this.Shift != temp.Shift || this.salary != temp.salary || this.subject != temp.subject)
            return false;
        return true;
    }
    /**
     *  Overriden function of obtaining a string representation of
     *  an instance of a class "Teacher"
     *  @return returns the string representation
     */
    @Override
    public String toString() {
        return super.toString() + " position , Shift : " + Shift + " , subject is " + subject + " , salary is "  + salary + ", ";
    }
    /**
     * Class "Builder" with fields: newTeacher, Count
     * @author User
     * @version 1.0
     */
    public static class Builder{

        /** Teacher field */
        private Teacher newTeacher;
        /** Count of Teachers field */
        private static int Count = 0;
        /**
         * Constructor - creating a new object
         * @see Builder#Builder()
         */
        public Builder(){
            newTeacher = new Teacher();
        }

        /**
         * Function  First Name designition
         * @param name - First Name of a teacher
         * @return returns current object
         */
        public Builder addFirstName(String name){
            newTeacher.firstName = name;
            return this;
        }

        /**
         * Function  Last name designition
         * @param lastName - Last name of a teacher
         * @return returns current object
         */
        public Builder addLastName(String lastName){
            newTeacher.lastName = lastName;
            return this;
        }
        /**
         * Function  age designition
         * @param age - age of a teacher
         * @return returns current object
         */

        public Builder addAge(int age){
            newTeacher.age = age;
            return this;
        }
        /**
         * Function email designition
         * @param email - email of a teacher
         * @return returns current object
         * @throws IllegalArgumentException - if the email address isn't valid
         */
        public Teacher.Builder addEmail(String email){
            Pattern p = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
            if (p.matcher(email).matches())
                newTeacher.email = email;
            else
                throw new IllegalArgumentException("Illegal Argument");
            return this;
        }
        /**
         * Function  position  designition
         * @return returns current object
         */

        public Builder addPosition(){
            newTeacher.position = "teacher";
            return this;
        }
        /**
         * Function  subject designition
         * @param subject - subject of a teacher
         * @return returns current object
         */
        public Builder addSubject(String subject){
            newTeacher.subject = subject;
            return this;
        }

        /**
         * Function  Shift designition
         * @param Shift - Shift of a teacher
         * @return returns current object
         */
        public Builder addShift(int Shift){
            newTeacher.Shift = Shift;
            return this;
        }
        /**
         * Function  Salary designition
         * @param salary - salary of a teacher
         * @return returns current object
         */
        public Builder addSalary(int salary){
            newTeacher.salary = salary;
            return this;
        }

        /**
         * Function of creating an object of class "Teacher"
         * @return returns new object of class "Teacher"
         */
        public Teacher Build() {
            newTeacher.id = ++Count;
            return  newTeacher;
        }
    }
}