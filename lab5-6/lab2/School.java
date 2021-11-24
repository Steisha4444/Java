package lab2;
import java.sql.*;
import java.util.Collection;

public class School {
    private int id;
    private String name;
    private String phoneNum;
    int idRegion;


    public School(int id, String name, String phoneCompany,int idRegion){
        this.id = id;
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

}
