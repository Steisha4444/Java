package lab2;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class ManagerWorker {

    private Connection conn;

    public ManagerWorker(){

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

    public void createTableWorkers() throws SQLException{

        String t="CREATE TABLE  if not exists workers (IdWorker INT(15) PRIMARY KEY , Age INT(2) NOT NULL ," +
                "Lastname VARCHAR(30) NOT NULL , Name VARCHAR(30) NOT NULL, Salary INT(15) NOT NULL ,"+
                "IdSchool INT(15), FOREIGN KEY(IdSchool) REFERENCES school(IdSchool));";

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(t);



    }


    public void deleteTable() throws SQLException{

        String t1 = "DROP TABLE workers;";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(t1);
        System.out.println("Deleted table");



    }

    //ADD WORKER


    public void addWorkerToTable(Worker obj) throws SQLException{
        PreparedStatement stmt = null;

        stmt = conn.prepareStatement("INSERT INTO workers VALUES(?,?,?,?,?,?);");
        stmt.setInt(1,obj.getId());
        stmt.setInt(2,obj.getAge());
        stmt.setString(3,obj.getLastName());
        stmt.setString(4,obj.getFirstName());
        stmt.setInt(5,obj.getSalary());
        stmt.setInt(6,obj.getSchoolId());
        stmt.execute();
        System.out.println("Added 1 worker");

    }


    //SELECT OPERATIONS

    //1) SELECT ALL AVAILABLE WORKERS;

    public Collection<Worker> selectAll() throws SQLException{
        Collection<Worker> workers = new ArrayList<Worker>();

        ResultSet rs = null;
        Statement stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM workers;");

        while(rs.next()){
            Worker w1 = new Worker(rs.getInt("IdWorker"),rs.getInt("Age"),rs.getString("Lastname"),rs.getString("Name"), rs.getInt("IdSchool"), rs.getInt("Salary"));
            workers.add(w1);
        }

        return workers;
    }




    //2) WORKERS WHO ARE OLDER
    public Collection<Worker> selectOlder(int age) throws SQLException{
        Collection<Worker> workers = new ArrayList<Worker>();
        ResultSet rs = null;
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM workers WHERE Age > ?;");
        stmt.setFloat(1,age);
        rs = stmt.executeQuery();

        while(rs.next()){
            Worker w1 = new Worker(rs.getInt("IdWorker"),rs.getInt("Age"),rs.getString("Lastname"),rs.getString("Name"), rs.getInt("Salary"), rs.getInt("IdSchool"));
            workers.add(w1);
        }

        return workers;
    }



    //3) WORKERS WHO WORK AT REGION
    public  Collection<Worker> selectWorkerInCompany(int idCity) throws SQLException{
        Collection<Worker> workers = new ArrayList<Worker>();

        ResultSet rs = null;
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM workers, school,region WHERE workers.IdSchool=school.IdSchool AND school.IdRegion=region.IdRegion AND region.IdRegion=?;");
        stmt.setFloat(1,idCity);
        rs = stmt.executeQuery();

        while(rs.next()){
            Worker w1 = new Worker(rs.getInt("IdWorker"),rs.getInt("Age"),rs.getString("Lastname"),rs.getString("Name"), rs.getInt("Salary"), rs.getInt("IdSchool"));
            workers.add(w1);
        }

        return workers;
    }


    //UPDATE OPERATIONS

    //1)UPDATE SALARY WORKERS WHO WORK AT SCHOOL
    public void UpdateSalary(int salary, int IdSchool) throws SQLException{
        Collection<Worker> workers = new ArrayList<Worker>();
        PreparedStatement stmt = conn.prepareStatement("UPDATE workers SET Salary=? WHERE IdSchool=?;");
        stmt.setInt(1,salary);
        stmt.setInt(2,IdSchool);
        stmt.executeUpdate();


    }


    //2)UPDATE SALARY WORKERS
    public void UpdateSalaryWithExperience() throws SQLException{
        Collection<Worker> workers = new ArrayList<Worker>();

        Statement stmt = conn.createStatement();
        stmt.executeUpdate("UPDATE workers SET Salary=Salary*0.3 ;");

    }



    //DELETE OPERATIONS

    //1) DELETE WORKERS WHO HAVE AGE MORE THAN GIVEN AGE
    public void DeleteWorkersForAge(int age) throws SQLException{
        Collection<Worker> workers = new ArrayList<Worker>();

        PreparedStatement stmt = conn.prepareStatement("DELETE FROM workers WHERE Age > ?");
        stmt.setInt(1,age);
        stmt.executeUpdate();

    }


    //2) DELETE WORKERS WHO HAVE GIVEN NAME

    public void deleteWorkerForName(String name) throws SQLException{
        Collection<Worker> workers = new ArrayList<Worker>();

        PreparedStatement stmt = conn.prepareStatement("DELETE FROM workers WHERE Name = ?");
        stmt.setString(1,name);
        stmt.executeUpdate();

    }


    //3) DELETE ALL INFORMATION FROM TABLE
    public void deleteAll() throws SQLException{

        String t1 = "DELETE FROM workers WHERE TRUE ;";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(t1);
        System.out.println("Deleted info");
    }
}