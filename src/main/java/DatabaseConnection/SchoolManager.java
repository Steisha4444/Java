package DatabaseConnection;

import Models.Region;
import Models.School;
import Models.Worker;


import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class SchoolManager {
    private Connection conn;
    private String url;
    private String user;
    private String pass;

    public SchoolManager(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    protected void connect() throws SQLException{
        if(conn == null || conn.isClosed()){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
            }
            catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            conn = DriverManager.getConnection(url,user,pass);
        }
    }

    public void closeConn() throws SQLException{
        conn.close();
    }

    public void createTableSchool() throws SQLException{

        String t="CREATE TABLE school(IdSchool INT(15) NOT NULL AUTO_INCREMENT , Name VARCHAR (30) NOT NULL ,"+
                " PhoneNumber VARCHAR (30) NOT NULL , IdRegion INT(30), FOREIGN KEY (IdRegion) REFERENCES region (IdRegion) ON DELETE CASCADE, PRIMARY KEY (IdSchool));";
        Statement stmt = this.conn.createStatement();
        stmt.executeUpdate(t);
    }

    public void editSchool(School company) throws SQLException{
        connect();
        PreparedStatement stmt = conn.prepareStatement("UPDATE school SET Name=?,PhoneNumber=?, IdRegion=? WHERE IdSchool=?;");

        stmt.setString(1,company.getName());
        stmt.setString(2,company.getPhoneNum());
        stmt.setInt(3,company.getIdRegion());
        stmt.setInt(4,company.getId());

        stmt.executeUpdate();
    }
    public void deleteTableSchool() throws SQLException{

        Statement stmt = this.conn.createStatement();
        stmt.executeUpdate("DROP TABLE school;");
    }
    //ADD COMPANY
    public void addSchool(School company) throws SQLException{
        connect();
        PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO school(Name,PhoneNumber,IdRegion) VALUES (?,?,?);");
        stmt.setString(1,company.getName());
        stmt.setString(2,company.getPhoneNum());
        stmt.setInt(3,company.getIdRegion());

        stmt.execute();


        System.out.println("Added 1 school");
    }
    public int maxId() throws SQLException{
        connect();
        int res=-1;
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT MAX(IdSchool) AS MaxId  FROM school; ");
        if(rs.next()) {
            res = rs.getInt("MaxId");
        }
        return res;

    }

    //SELECT OPERATIONS

    //1)SELECT ALL COMPANY
    public Collection<School> selectAll() throws SQLException{
        connect();
        Collection<School>companies = new ArrayList<School>();

        ResultSet rs = null;
        Statement stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT k.IdSchool,k.Name,k.PhoneNumber, com.Name FROM school k,region com WHERE k.IdRegion=com.IdRegion;");

        while(rs.next()){


            School company = new School(rs.getInt("IdSchool"),rs.getString("Name"),rs.getString("PhoneNumber"),rs.getInt("IdRegion"));
            companies.add(company);
        }

        return companies;

    }


    public School getSchoolById(int id) throws SQLException{
        connect();
        School company = null;
        ResultSet rs = null;
        PreparedStatement ptmt = conn.prepareStatement("SELECT k.IdSchool,k.Name,k.PhoneNumber, com.Name FROM school k, region com WHERE k.IdRegion=com.IdRegion AND k.IdSchool=?;");
        ptmt.setInt(1,id);

        rs = ptmt.executeQuery();

        while (rs.next()){
            company = new School(rs.getInt("IdSchool"),rs.getString("Name"),rs.getString("PhoneNumber"),rs.getInt("IdRegion"));
        }

        return company;
    }

    //2) SELECT COMPANIES WHICH ARE LOCATED IN SPECIFIC CITY
    public Collection<School> selectSchoolByRegion(String city) throws SQLException{
        ResultSet rs = null;
        Collection<School> companies = new ArrayList<School>();
        connect();
        PreparedStatement stmt = this.conn.prepareStatement("SELECT k.IdSchool, k.Name,k.PhoneNumber,com.Name FROM school k,region com WHERE k.IdRegion=com.IdRegion AND  com.Name=? ORDER BY k.Name;");
        stmt.setString(1,city);
        rs = stmt.executeQuery();

        while(rs.next()){

            School company = new School(rs.getInt("IdSchool"),rs.getString("Name"),rs.getString("PhoneNumber"),rs.getInt("IdRegion"));
            companies.add(company);
        }

        return companies;
    }

    public Collection<String> getAllNames() throws SQLException{
        connect();
        Collection<String> names = new ArrayList<String>();
        ResultSet rs = null;
        Statement stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT Name FROM school");
        while (rs.next()){
            String temp = rs.getString("Name");
            names.add(temp);
        }

        return names;
    }


    public int getIdByName(String name) throws SQLException {
        int id = 0;
        connect();

        ResultSet rs = null;

        PreparedStatement stmt = conn.prepareStatement("SELECT IdSchool FROM school WHERE Name=?;");
        stmt.setString(1,name);

        rs = stmt.executeQuery();

        while(rs.next()){
            id = rs.getInt("IdSchool");
        }

        return id;
    }

    //DELETE OPERATIONS
    public void deleteById(int id) throws SQLException{
        connect();
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM school WHERE IdSchool=?;");
        stmt.setInt(1,id);
        stmt.executeUpdate();
    }

}
