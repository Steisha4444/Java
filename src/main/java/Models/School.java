package Models;
import DatabaseConnection.RegionManager;
import DatabaseConnection.SchoolManager;

import java.sql.*;
import java.util.Collection;

public class School {
    private int id;
    private String name;
    private String phoneNum;
    int idRegion;


    public School(int id, String name, String phoneCompany, int idRegion) {
        this.id = id;
        this.name = name;
        this.phoneNum = phoneCompany;
        this.idRegion = idRegion;

    }

    public School(String name, String phoneCompany, int idRegion) {

        this.name = name;
        this.phoneNum = phoneCompany;
        this.idRegion = idRegion;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setIdRegion(int id) {
        this.idRegion = id;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNum + '\'' +
                '}';
    }

    public static void main(String[] args) throws SQLException {
        School company1 = new School("Softserve", "23-55-15", 1);
        School company2 = new School("Glovo", "034-43-11-231", 2);
        School company3 = new School("Happy", "765-09-00", 1);
        School company4 = new School("Okko", "321-45-22", 2);
        School company5 = new School("Love", "098-12-90-098", 2);

        SchoolManager manager = new SchoolManager("jdbc:mysql://localhost:3306/webApp", "user", "Shved Anastasiia");
        RegionManager cityManager = new RegionManager("jdbc:mysql://localhost:3306/webApp", "user", "Shved Anastasiia");
        manager.createTableSchool();

        manager.addSchool(company1);
        manager.addSchool(company2);
        manager.addSchool(company3);
        manager.addSchool(company4);
        manager.addSchool(company5);

        Collection<School> companies = manager.selectAll();
        for (School company: companies
             ) {
            System.out.println(company);
        }


       School company = manager.getSchoolById(3);
        System.out.println(company);
        Collection<String> name = cityManager.getAllNames();
        for (String nam: name
             ) {
            System.out.println(nam);
        }

        Collection<School> companies1 = manager.selectSchoolByRegion("Lviv");
        for (School comp: companies1
             ) {
            System.out.println(comp);
        }
Collection<String> name1 = manager.getAllNames();
        for (String nam: name1
             ) {
            System.out.println(nam);
        }
        System.out.println(manager.getIdByName("Okko"));
    }

}