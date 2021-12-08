package DatabaseConnection;
 import Models.Region;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class RegionManager{

    private Connection conn;
    private String url;
    private String user;
    private String pass;

    public RegionManager(String url, String user, String pass) {

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


    //TABLE OPERATIONS

    public void createTableCity() throws SQLException{

        String t="CREATE TABLE region(IdRegion INT(15) NOT NULL AUTO_INCREMENT , Name VARCHAR (30) NOT NULL, PRIMARY KEY (IdRegion));";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(t);
    }



    //ADD CITY
    public void addRegion(Region city) throws SQLException{
        connect();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO region(Name) VALUES(?);");
        stmt.setString(1,city.getName());

        stmt.execute();
    }


    public Collection<Region> selectAll() throws SQLException{
        connect();
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

    public Collection<String> getAllNames() throws SQLException{
        connect();
        Collection<String> names=new ArrayList<String>();
        ResultSet rs = null;
        Statement stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT Name FROM region;");
        while(rs.next()){
            String name = rs.getString("Name");
            names.add(name);
        }

        return names;
    }

    public int getIdRegionByName(String name) throws SQLException{
        int id = 0;
        connect();

        ResultSet rs = null;
        PreparedStatement stmt = conn.prepareStatement("SELECT IdRegion FROM region WHERE Name=?;");
        stmt.setString(1,name);
        rs = stmt.executeQuery();
        while (rs.next()){
            id= rs.getInt("IdRegion");
        }
        return id;
    }
    //DELETE OPERATIONS
    public void deleteTable() throws SQLException {

        Statement stmt = conn.createStatement();
        stmt.executeUpdate("DROP TABLE region;");

    }


    public void deleteRegion(int id) throws SQLException{
        connect();
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM region WHERE IdRegion=?;");
        stmt.setInt(1,id);
        stmt.executeUpdate();

    }

}