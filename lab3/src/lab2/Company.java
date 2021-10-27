package lab2;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Array;
import java.util.*;
public class Company extends Worker{

     int id;

     String Name;

      List<Worker> workers  ;

    public Company(){};
    public Company(int id, String name , List<Worker> w) {
        this.id=id;
        this.Name=name;
        this.workers= w;
     //   for (int i=0 ; i <= w.length; i++) {
         //   this.workers.add(w[i]);
      //  }
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return Name;
    }
    public List getWorkers() {
        return workers;
    }
    public void setId(int id) {

            this.id = id;
    }
    public void setName(String Lname) {
        this.Name = Lname;

    }
    public void setWorkers(List<Worker> w) {
        this.workers = w;
    }
    @Override
    public String toString() {
        return "Company-Id " + id + " ,Name of Company " + Name +  " , Worker \n" +  workers.toString() ;
    }
}
