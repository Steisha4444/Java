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
    /** Field University where student is studying*/
    String University;
    /**
     * Overridden function of obtaining the hash code
     * @return returns the numeric value of the hash code
     */
    public int hashCode() {
        final int prime = 41;
        int result = super.hashCode();
        result = prime * result + (int) (this.termMonth);
        result = prime * result + this.University.length();
        return result;
    }
    /**
     * Overridden function of comparison an instance of
     * the class "Assistant" and an instance of the class "Object"
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
        Assistant temp = (Assistant) obj;
        if (this.firstName != temp.firstName || this.lastName != temp.lastName || this.age != temp.age ||
                this.email != temp.email || this.Shift != temp.Shift || this.salary != temp.salary || this.subject != temp.subject
                || this.termMonth != temp.termMonth || this.University != temp.University)
            return false;
        return true;
    }
    /**
     *  Overriden function of obtaining a string representation of
     *  an instance of a class "Assistant"
     *  @return returns the string representation
     */
    @Override
    public String toString() {
        return super.toString() + " Term of internship: " + termMonth + " , Univesity :" + University;
    }
    /**
     * Class "Builder" with fields: newAssistant, Count
     * @author User
     * @version 1.0
     */
    public static class Builder {
        private Assistant newAssistant;
        private static int Count = 0;
        /**
         * Constructor - creating a new object
         * @see Builder#Builder()
         */
        public Builder(){
            newAssistant = new Assistant();
        }
        /**
         * Function last name designition
         * @param name - last name of a Assistant
         * @return returns current object
         */
        public Builder addLastName(String name) {
            newAssistant.lastName = name;
            return this;
        }
        /**
         * Function first name designition
         * @param name - first name of a Assistant
         * @return returns current object
         */
        public Builder addFirstName(String name) {
            newAssistant.firstName = name;
            return this;
        }
        /**
         * Function age designition
         * @param age - first name of a Assistant
         * @return returns current object
         */
        public Builder addAge(int age) {
            newAssistant.age = age;
            return this;
        }
        /**
         * Function email designition
         * @param email - email of an assistant
         * @return returns current object
         * @throws IllegalArgumentException - if the email address isn't valid
         */
        public Builder addEmail(String email) {
            Pattern p = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
            if (p.matcher(email).matches())
                newAssistant.email = email;
            else
                throw new IllegalArgumentException("Illegal Argument");
            return this;
        }/**
         * Function  position  designition
         * @return returns current object
         */
        public Builder addPosition(){
            newAssistant.position = "Assistant";
            return this;
        }
        /**
         * Function  subject designition
         * @param subject - subject of an assistant
         * @return returns current object
         */
        public Builder addSubject(String subject){
            newAssistant.subject = subject;
            return this;
        }
        /**
         * Function  Shift designition
         * @param Shift - Shift of an assistant
         * @return returns current object
         */

        public Builder addShift(int Shift){
            newAssistant.Shift = Shift;
            return this;
        }
        /**
         * Function  Salary designition
         * @param salary - salary of an assistant
         * @return returns current object
         */
        public Builder addSalary(int salary){
            newAssistant.salary = salary;
            return this;
        }
        /**
         * Function  term designition
         * @param Term - term of an internship of an assistant
         * @return returns current object
         */
        public Builder addTerm(double Term){
            newAssistant.termMonth = Term;
            return this;
        }
        /**
         * Function  University designition
         * @param University- University of an assistant
         * @return returns current object
         */
        public Builder addUniversity(String University){
            newAssistant.University = University;
            return this;
        }
        /**
         * Function of creating an object of class "Assistant"
         * @return returns new object of class "Assistant"
         */
        public Assistant Build() {
            newAssistant.id = ++Count;
            return  newAssistant;
        }
    }
}
