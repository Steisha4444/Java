package Models;
import DatabaseConnection.RegionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;


public class Region {

    private int id;
    private String Name;

    public Region(String Name) {
        this.Name = Name;
    }

    public Region(int id, String Name) {
        this.id = id;
        this.Name = Name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                '}';
    }

    public static void main(String[] args) throws SQLException {
        Region city1 = new Region("Chernivtsi");
        Region city2 = new Region("Lviv");
        RegionManager managerCity = new RegionManager("jdbc:mysql://localhost:3306/webApp", "user", "Shved Anastasiia");
        managerCity.createTableCity();

       managerCity.addRegion(city1);
       managerCity.addRegion(city2);

        managerCity.deleteTable();

      Collection<Region> city = new ArrayList<Region>();

       city = managerCity.selectAll();

        for (Region cities: city
             ) {
          System.out.println(cities);
       }
       managerCity.closeConn();
    }

}