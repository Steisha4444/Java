package lab2;
import java.io.*;
import lab2.Worker;

public class Main {
    public static void main(String[] args) {
        Worker a1 = new Worker
                .Builder()
                .addAge(34)
                .addLastName("Smith")
                .addFirstName("Revil")
                .addEmail("a.b@gmail.com")
                .Build();

        Worker a2 = new Worker
                .Builder()
                .addAge(24)
                .addLastName("Jackson")
                .addFirstName("Stephan")
                .addEmail("s.b@gmail.com")
                .Build();

        System.out.println("There are workers:");
        System.out.println(a1 + "\n" + a2);
        System.out.println("\tThey are equals:" + a1.equals(a2));


        Worker c1 = new Teacher
                .Builder()
                .addAge(31)
                .addLastName("Daniluk")
                .addFirstName("Tatiana")
                .addEmail("a.t@gmail.com")
                .addSalary(3000)
                .addShift(1)
                .addPosition()
                .addSubject("Math")
                .Build();

        Worker c2 = c1;
        System.out.println("\nThere are teachers:");
        System.out.println(c1 + "\n" + c2);
        System.out.println("\tThey are equals:" + c1.equals(c2));

      Worker t1 = new Assistant
              .Builder()
              .addAge(34)
              .addLastName("Kim")
              .addFirstName("Daria")
              .addEmail("k.daria@gmail.com")
              .addSalary(2500)
              .addShift(1)
              .addPosition()
              .addSubject("Biology")
              .addTerm(2.5)
              .addUniversity("CHNU")
              .Build();

        Worker t2 = new Assistant
                .Builder()
                .addAge(30)
                .addLastName("Shved")
                .addFirstName("Vladyslav")
                .addEmail("v.shved@gmail.com")
                .addSalary(2400)
                .addShift(2)
                .addPosition()
                .addSubject("Literature")
                .addTerm(1.5)
                .addUniversity("CHNU")
                .Build();

        System.out.println("\nThere are assistants:");
        System.out.println(t1 + "\n" + t2);
        System.out.println("\tThey are equals:" + t1.equals(t2));

    }
}
