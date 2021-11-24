package lab2;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;


public class Region {

    private int id;
    private String Name;

    public Region(int id, String Name){
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


}
