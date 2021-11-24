package lab2;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;


public class Manager {

    private Connection conn;

    public Manager(){

        try {
            String url = "jdbc:mysql://localhost:3306/lab5_1";
            String user = "user";
            String pass = "Shved Anastasiia";
            this.conn = DriverManager.getConnection(url, user, pass);
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void closeConn() throws SQLException{
        conn.close();
    }


    //TABLE OPERATIONS
    public void createTableSchool() throws SQLException{

        String t="CREATE TABLE if not exists school (IdSchool INT(15) PRIMARY KEY , Name VARCHAR(30) NOT NULL ,"+
                " PhoneNumber VARCHAR(30) NOT NULL ,IdRegion INT(15), FOREIGN KEY(IdRegion) REFERENCES region(IdRegion));";
        Statement stmt = this.conn.createStatement();
        stmt.executeUpdate(t);
    }



    public void deleteTableCompany() throws SQLException{

        Statement stmt = this.conn.createStatement();
        stmt.executeUpdate("DROP TABLE school;");
    }


    //ADD SCHOOL
    public void addCompany(School school) throws SQLException{

        PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO school VALUES (?,?,?,?);");
        stmt.setInt(1,school.getId());
        stmt.setString(2,school.getName());
        stmt.setString(3,school.getPhoneNum());
        stmt.setInt(4,school.getIdRegion());

        stmt.execute();


        System.out.println("Added 1 school");
    }



    //SELECT OPERATIONS

    //1)SELECT ALL SCHOOLS
    public Collection<School> selectAll() throws SQLException{

        Collection<School>schools = new ArrayList<School>();

        ResultSet rs = null;
        Statement stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM school;");
        System.out.println("OK");
        while(rs.next()){
            System.out.println("OK");
            School company = new School(rs.getInt("IdSchool"),rs.getString("Name"),rs.getString("PhoneNumber"),rs.getInt("IdRegion"));
            schools.add(company);
        }

        return schools;

    }


    //2) SELECT SCHOOL WHICH ARE LOCATED IN SPECIFIC CITY
    public Collection<School> selectWorkerForSchool(String region) throws SQLException{
        ResultSet rs = null;
        Collection<School> schools = new ArrayList<School>();

        PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM school,region WHERE school.IdRegion=region.IdRegion AND region.Name=?;");
        stmt.setString(1,region);
        rs = stmt.executeQuery();

        while(rs.next()){
            School company = new School(rs.getInt("IdSchool"),rs.getString("Name"),rs.getString("PhoneNumber"),rs.getInt("IdRegion"));
            schools.add(company);
        }

        return schools;
    }



    //UPDATE OPERATIONS

    //1) UPDATE NUMBERS IN THAT SCHOOLS WHICH ARE LOCATED IN SPECIFIC CITY
    public void updatePhone(String number, String region) throws SQLException{

        PreparedStatement stmt = this.conn.prepareStatement("UPDATE school,region SET school.PhoneNumber = ? WHERE school.IdRegion=region.IdRegion AND region.Name=?;");
        stmt.setString(1,number);
        stmt.setString(2,region);

        stmt.executeUpdate();
    }



    //DELETE OPERATIONS
    public void deleteForName(String nameschool) throws SQLException{

        PreparedStatement stmt = this.conn.prepareStatement("DELETE FROM school WHERE Name=?;");
        stmt.setString(1,nameschool);
        stmt.executeUpdate();
    }


    public void deleteAll() throws SQLException{

        Statement stmt = this.conn.createStatement();
        stmt.executeUpdate("DELETE FROM school WHERE TRUE;");
        System.out.println("Delete info");
    }

}