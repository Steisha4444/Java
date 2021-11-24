package lab2;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class ManagerRegion {

    private Connection conn;

    public ManagerRegion (){

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

    public void createTableRegion() throws SQLException{

        String t="CREATE TABLE if not exists region(IdRegion INT(15) PRIMARY KEY , Name VARCHAR(30) NOT NULL);";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(t);
    }



    //ADD CITY
    public void addToTable(Region city) throws SQLException{

        PreparedStatement stmt = conn.prepareStatement("INSERT INTO region VALUES(?,?);");
        stmt.setInt(1,city.getId());
        stmt.setString(2,city.getName());

        stmt.execute();
    }


    public Collection<Region> selectAll() throws SQLException{

        Statement stmt = conn.createStatement();
        ResultSet rs = null;

        Collection<Region> cities = new ArrayList<Region>();
        rs = stmt.executeQuery("SELECT * FROM region;");

        while(rs.next()){
            Region city = new Region(rs.getInt("IdRegion"),rs.getString("Name"));
            cities.add(city);
        }

        return cities;
    }

    //DELETE OPERATIONS
    public void deleteTable() throws SQLException {

        Statement stmt = conn.createStatement();
        stmt.executeUpdate("DROP TABLE region;");

    }


    public void deleteInfo() throws SQLException{
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("DELETE FROM region WHERE TRUE;");

    }

}