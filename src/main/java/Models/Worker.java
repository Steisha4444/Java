package Models;
import DatabaseConnection.SchoolManager;
import DatabaseConnection.WorkerManager;
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


    public Worker(int age, String Lname, String Fname, int SId, int salary) {
        if (age > 0)
            this.age = age;

        this.SchoolId = SId;
        this.lastName = Lname;
        this.firstName = Fname;
        this.salary = salary;
    }

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
        return "id = " + id + " " + firstName + "  " + lastName + ", " + age + " years , " + salary + "$ , " + " " + SchoolId + " " + position;
    }

    public static void main(String[] args) throws SQLException {
        Worker w1 = new Worker(42, "Jim", "Ivan", 1, 135555);

        Worker w2 = new Worker(41, "Malish", "Mariya", 2, 30000);

        Worker w3 = new Worker(23, "Polian", "Alexandr", 3, 45000);
        Worker w4 = new Worker(36, "Mac", "Petro", 2, 34000);
        Worker w5 = new Worker(25, "Lozar", "Mary", 1, 12000);
        Worker w6 = new Worker(50, "Kerch", "Hanna", 3, 34000);
        Worker w7 = new Worker(33, "Vatin", "Vez", 2, 34500);
        Worker w8 = new Worker(40, "Fallon", "Petro", 2, 23000);
        Worker w9 = new Worker(31, "Triten", "John", 2, 12400);
        Worker w10 = new Worker(50, "Panche", "Andriy", 1, 35000);
        Worker w11 = new Worker(21, "Makarchuk", "Nataly", 2, 22900);
        Worker w12 = new Worker(26, "Akerman", "Lev", 3, 56000);
        Worker w13 = new Worker(33, "Yahnenko", "Zed", 1, 23600);
        Worker w14 = new Worker(38, "Pity", "Akali", 3, 34000);
        Worker w15 = new Worker(20, "Atamanuk", "Rakan", 1, 11000);

        WorkerManager managerWorker = new WorkerManager("jdbc:mysql://localhost:3306/webApp","user","Shved Anastasiia");
        managerWorker.createTableWorkers();

        managerWorker.addWorkerToTable(w1);
        managerWorker.addWorkerToTable(w2);
        managerWorker.addWorkerToTable(w3);
        managerWorker.addWorkerToTable(w4);
        managerWorker.addWorkerToTable(w5);
        managerWorker.addWorkerToTable(w6);
        managerWorker.addWorkerToTable(w7);
        managerWorker.addWorkerToTable(w8);
        managerWorker.addWorkerToTable(w9);
        managerWorker.addWorkerToTable(w10);
        managerWorker.addWorkerToTable(w11);
        managerWorker.addWorkerToTable(w12);
        managerWorker.addWorkerToTable(w13);
        managerWorker.addWorkerToTable(w14);
        managerWorker.addWorkerToTable(w15);

Collection<Worker> workers = managerWorker.selectAll();
        for (Worker worker: workers
             ) {
            System.out.println(worker);
        }
Worker worker55 = managerWorker.getWorkerById(6);
        System.out.println(worker55);
        SchoolManager companyManager = new SchoolManager("jdbc:mysql://localhost:3306/webApp","user","Shved Anastasiia");
        int id = companyManager.getIdByName("Good");
        System.out.println(id);
        Worker worker = new Worker(45,23,"Kalush","Mariya",id, 45500);
        managerWorker.editWorker(worker);


    }
}