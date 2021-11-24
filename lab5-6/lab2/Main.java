package lab2;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.time.LocalDate;
import java.util.regex.Pattern;

import java.io.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        Region city1 = new Region(1, "Chernivtsi");
        Region city2 = new Region(2, "Lviv");
        Region city3 = new Region(3, "Kyiv");

        ManagerRegion managerCity = new ManagerRegion();

        managerCity.createTableRegion();
        managerCity.addToTable(city1);
        managerCity.addToTable(city2);
        managerCity.addToTable(city3);

        Collection<Region> city = new ArrayList<Region>();

        city = managerCity.selectAll();

        for (Region cities : city) {
            System.out.println(cities);
        }

        School company1 = new School(1, "SoftSkill", "23-55-15", 1);
        School company2 = new School(2, "Junn", "034-43-11-231", 1);
        School company3 = new School(3, "Mateo", "765-09-00", 2);
        School company4 = new School(4, "Oliver", "321-45-22", 3);
        School company5 = new School(5, "Famine", "098-12-90-098", 2);

        Manager manager = new Manager();
        manager.createTableSchool();

        manager.addCompany(company1);
        manager.addCompany(company2);
        manager.addCompany(company3);
        manager.addCompany(company4);
        manager.addCompany(company5);

        //SELECT OPERATIONS
//        1) SELECT ALL COMPANIES
        Collection<School> companies = manager.selectAll();
        for (School company : companies) {
            System.out.println(company);
        }

//        2) SELECT COMPANY WHICH ARE LOCATED IN SPECIFIC CITY
        Collection<School> companies1 = manager.selectWorkerForSchool("Chernivtsi");
        for (School company : companies1 ) {
            System.out.println(company);
        }
//     UPDATE OPERATION
//        UPDATE PHONE COMPANY
        manager.updatePhone("22-222-22", "Chernivtsi");

        Collection<School> companies2 = manager.selectAll();
        for (School company : companies) {
            System.out.println(company);
        }
//        DELETE INFROMATION

//        //1) DELETE COMPANY FOR NAME
        manager.deleteForName("Okko");

        Collection<School> companies3 = manager.selectAll();
        for (School company : companies3 ) {
            System.out.println(company);
        }

//        2) DELETE ALL COMPANIES


        Collection<School> companies4 = manager.selectAll();
        for (School company : companies4) {
            System.out.println(company);
        }


        Worker w1 = new Worker(1, 45, "Petras", "Ivan", 1, 23000);
        Worker w2 = new Worker(2, 41, "Malish", "Mariya", 2, 30000);
        Worker w3 = new Worker(3, 23, "Polian", "Alexandr", 3, 45000);
        Worker w4 = new Worker(4, 36, "Mac", "Petro", 2, 34000);
        Worker w5 = new Worker(5, 25, "Lozar", "Mary", 1, 12000);
        Worker w6 = new Worker(6, 50, "Kerch", "Hanna", 3, 34000);
        Worker w7 = new Worker(7, 33, "Vatin", "Vez", 2, 34500);
        Worker w8 = new Worker(8, 40, "Fallon", "Petro", 2, 23000);
        Worker w9 = new Worker(9, 31, "Triten", "John", 2, 12400);
        Worker w10 = new Worker(10, 50, "Panche", "Andriy", 1, 35000);
        Worker w11 = new Worker(11, 21, "Makarchuk", "Nataly", 2, 22900);
        Worker w12 = new Worker(12, 26, "Akerman", "Lev", 3, 56000);
        Worker w13 = new Worker(13, 33, "Yahnenko", "Zed", 1, 23600);
        Worker w14 = new Worker(14, 38, "Pity", "Akali", 3, 34000);
        Worker w15 = new Worker(15, 20, "Atamanuk", "Rakan", 1, 11000);


        ManagerWorker managerWorker = new ManagerWorker();

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

//SELECT OPERATIONS
        //1)SELECT ALL WORKERS
        Collection<Worker> workers = new ArrayList<Worker>();

        workers = managerWorker.selectAll();
        for (Worker worker : workers) {
            System.out.println(worker);

        }

        //2) WORKERS WHO HAVE SALARY MORE THAN GIVEN
        Collection<Worker> workers1 = new ArrayList<Worker>();
//
        workers1 = managerWorker.selectOlder(30);
        for (Worker worker : workers1) {
            System.out.println(worker);

        }
        //3) WORKERS WHO WORK AT COMPANY
        Collection<Worker> workers2 = new ArrayList<Worker>();

        workers2 = managerWorker.selectWorkerInCompany(1);
        for (Worker worker : workers2 ) {
            System.out.println(worker);
        }
       //UPDATE OPERATION
        //1) UPDATE SALARY WORKERS

        managerWorker.UpdateSalary(5200, 4);
        Collection<Worker> workers3 = new ArrayList<Worker>();

        workers3 = managerWorker.selectAll();
        for (Worker worker : workers3) {
            System.out.println(worker);

        }
        //2)UPDATE SALARY WORKERS WHO HAVE EXPERIENCE LESS THAN 5 YEARS

        managerWorker.UpdateSalaryWithExperience();
        Collection<Worker> workers4 = new ArrayList<Worker>();

        workers4 = managerWorker.selectAll();
        for (Worker worker : workers4) {
            System.out.println(worker);
        }
        //DELETE OPERATIONS
        //1) DELETE WORKERS WHO HAVE AGE MORE THAN GIVEN AGE
        managerWorker.DeleteWorkersForAge(50);
        Collection<Worker> workers5 = new ArrayList<Worker>();

        workers5 = managerWorker.selectAll();
        for (Worker worker : workers5) {
            System.out.println(worker);
        }

        //2)  DELETE WORKERS WHO HAVE GIVEN NAME
        managerWorker.deleteWorkerForName("Petro");
        Collection<Worker> workers6 = new ArrayList<Worker>();

        workers6 = managerWorker.selectAll();
        for (Worker worker : workers6) {
            System.out.println(worker);
        }

        //3)DELETE ALL WORKERS

        Collection<Worker> workers7 = new ArrayList<Worker>();

        workers7 = managerWorker.selectAll();
        for (Worker worker : workers7) {
            System.out.println(worker);
        }
//        managerWorker.deleteTable();
//        manager.deleteTableCompany();
//        managerCity.deleteTable();


        manager.closeConn();
        managerCity.closeConn();
        managerWorker.closeConn();
    }
}
