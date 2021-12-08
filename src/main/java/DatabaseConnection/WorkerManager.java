package DatabaseConnection;

import Models.Worker;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class WorkerManager {

    private Connection conn;
    private String url;
    private String user;
    private String pass;

    public WorkerManager(String url, String user, String pass){
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

    public void createTableWorkers() throws SQLException{

//        String t="CREATE TABLE workers(Id_worker INT(15) NOT NULL AUTO_INCREMENT , Surname VARCHAR (30) NOT NULL ," +
//                " Name VARCHAR (30) NOT NULL , Lastname VARCHAR(30) NOT NULL , Age INT(2) NOT NULL,"+
//                " Salary FLOAT (10) NOT NULL , Experience INT(2) NOT NULL, CodeCompany INT(10), "+
//                "FOREIGN KEY(CodeCompany) REFERENCES company(Id_company) ON DELETE CASCADE, PRIMARY KEY(Id_worker) );";
        String t="CREATE TABLE  if not exists workers (IdWorker INT(15)  NOT NULL AUTO_INCREMENT , Age INT(2) NOT NULL ," +
                "Lastname VARCHAR(30) NOT NULL , Name VARCHAR(30) NOT NULL, Salary INT(15) NOT NULL ,"+
                "IdSchool INT(15), FOREIGN KEY(IdSchool) REFERENCES school(IdSchool)ON DELETE CASCADE, PRIMARY KEY(IdWorker));";
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
        connect();
        PreparedStatement stmt = null;

        stmt = conn.prepareStatement("INSERT INTO workers(Surname,Name,Lastname,Age,Salary,Experience,CodeCompany) VALUES(?,?,?,?,?,?,?);");
        stmt.setInt(1,obj.getAge());
        stmt.setString(2,obj.getLastName());
        stmt.setString(3,obj.getFirstName());
        stmt.setInt(4,obj.getSalary());
        stmt.setInt(5,obj.getSchoolId());
        stmt.execute();
        System.out.println("Added 1 worker");

    }


    //SELECT OPERATIONS

    //1) SELECT ALL AVAILABLE WORKERS;

    public Collection<Worker> filterByAge(int flag) throws SQLException{
        connect();
        Collection<Worker> workers = new ArrayList<Worker>();

        ResultSet rs = null;
        Statement stmt = conn.createStatement();
        if(flag == 0) {
            rs = stmt.executeQuery("SELECT w.IdWorker, w.Age,w.Lastname,w.Name,w.Salary,c.Name AS Name_company FROM workers w, school c WHERE w.IdSchool=c.IdSchool AND w.Age < 20 ORDER BY w.Age;");
            while(rs.next()){

                Worker w1 = new Worker(rs.getInt("IdWorker"),rs.getInt("Age"),rs.getString("Lastname"),rs.getString("Name"), rs.getInt("IdSchool"), rs.getInt("Salary"));
                workers.add(w1);
            }
            return workers;
        }

        else if(flag == 1){
            rs = stmt.executeQuery("SELECT w.IdWorker, w.Age,w.Lastname,w.Name,w.Salary,c.Name AS Name_company FROM workers w, school c WHERE w.IdSchool=c.IdSchool AND w.Age >= 20 AND w.Age < 40 ORDER BY w.Age;");
            while(rs.next()){

                Worker w1 = new Worker(rs.getInt("IdWorker"),rs.getInt("Age"),rs.getString("Lastname"),rs.getString("Name"), rs.getInt("IdSchool"), rs.getInt("Salary"));
                workers.add(w1);
            }
            return workers;
        }

        else if(flag == 2){
            rs = stmt.executeQuery("SELECT w.IdWorker, w.Age,w.Lastname,w.Name,w.Salary,c.Name AS Name_company FROM workers w, school c WHERE w.IdSchool=c.IdSchool AND w.Age >= 40 AND w.Age < 50 ORDER BY w.Age;");
            while(rs.next()){

                Worker w1 = new Worker(rs.getInt("IdWorker"),rs.getInt("Age"),rs.getString("Lastname"),rs.getString("Name"), rs.getInt("IdSchool"), rs.getInt("Salary"));
                workers.add(w1);
            }
            return workers;
        }

        else if(flag ==3){
            rs = stmt.executeQuery("SELECT w.IdWorker, w.Age,w.Lastname,w.Name,w.Salary,c.Name AS Name_company FROM workers w, school c WHERE w.IdSchool=c.IdSchool AND w.Age >= 50 AND w.Age < 70 ORDER BY w.Age;");
            while(rs.next()){

                Worker w1 = new Worker(rs.getInt("IdWorker"),rs.getInt("Age"),rs.getString("Lastname"),rs.getString("Name"), rs.getInt("IdSchool"), rs.getInt("Salary"));
                workers.add(w1);
            }
            return workers;
        }

        return null;
    }


    public Collection<Worker> filterBySalary(int flag) throws SQLException{
        connect();
        Collection<Worker> workers = new ArrayList<Worker>();

        ResultSet rs = null;
        Statement stmt = conn.createStatement();
        if(flag == 0) {
            rs = stmt.executeQuery("SELECT w.IdWorker, w.Age,w.Lastname,w.Name,w.Salary,c.Name AS Name_company FROM workers w, school c WHERE w.IdSchool=c.IdSchool AND w.Salary < 17000  ORDER BY w.Salary;");
            while(rs.next()){

                Worker w1 = new Worker(rs.getInt("IdWorker"),rs.getInt("Age"),rs.getString("Lastname"),rs.getString("Name"), rs.getInt("IdSchool"), rs.getInt("Salary"));
                workers.add(w1);
            }
            return workers;
        }

        else if(flag == 1){
            rs = stmt.executeQuery("SELECT w.IdWorker, w.Age,w.Lastname,w.Name,w.Salary,c.Name AS Name_company FROM workers w, school c WHERE w.IdSchool=c.IdSchool AND w.Salary >= 17000 AND w.Salary< 25000  ORDER BY w.Salary;");
            while(rs.next()){

                Worker w1 = new Worker(rs.getInt("IdWorker"),rs.getInt("Age"),rs.getString("Lastname"),rs.getString("Name"), rs.getInt("IdSchool"), rs.getInt("Salary"));
                workers.add(w1);
            }
            return workers;
        }

        else if(flag == 2){
            rs = stmt.executeQuery("SELECT w.IdWorker, w.Age,w.Lastname,w.Name,w.Salary,c.Name AS Name_company FROM workers w, school c WHERE w.IdSchool=c.IdSchool AND w.Salary >= 25000 AND w.Salary< 35000  ORDER BY w.Salary;");
            while(rs.next()){

                Worker w1 = new Worker(rs.getInt("IdWorker"),rs.getInt("Age"),rs.getString("Lastname"),rs.getString("Name"), rs.getInt("IdSchool"), rs.getInt("Salary"));
                workers.add(w1);
            }
            return workers;
        }

        else if(flag ==3){
            rs = stmt.executeQuery("SELECT w.IdWorker, w.Age,w.Lastname,w.Name,w.Salary,c.Name AS Name_company FROM workers w, school c WHERE w.IdSchool=c.IdSchool AND w.Salary >= 35000  ORDER BY w.Salary;");
            while(rs.next()){

                Worker w1 = new Worker(rs.getInt("IdWorker"),rs.getInt("Age"),rs.getString("Lastname"),rs.getString("Name"), rs.getInt("IdSchool"), rs.getInt("Salary"));
                workers.add(w1);
            }
            return workers;
        }

        return null;
    }

    public Collection<Worker> filterBySchool(String name) throws SQLException{
        connect();
        ResultSet rs = null;
        Collection<Worker> workers1 = new ArrayList<Worker>();

        PreparedStatement stmt = conn.prepareStatement("SELECT w.IdWorker, w.Age,w.Lastname,w.Name,w.Salary,c.Name AS Name_company FROM workers w, school c WHERE w.IdSchool=c.IdSchool AND c.Name=? ORDER BY w.Lastname;");
        stmt.setString(1,name);

        rs = stmt.executeQuery();
        while(rs.next()){

            Worker w1 = new Worker(rs.getInt("IdWorker"),rs.getInt("Age"),rs.getString("Lastname"),rs.getString("Name"), rs.getInt("IdSchool"), rs.getInt("Salary"));
            workers1.add(w1);
        }

        return workers1;
    }


    public Worker getWorkerById(int id) throws SQLException{
        Worker worker = null;
        connect();

        ResultSet rs = null;
        PreparedStatement stmt = null;
        stmt = conn.prepareStatement("SELECT w.IdWorker, w.Age,w.Lastname,w.Name,w.Salary,c.Name AS Name_company FROM workers w, school c WHERE w.IdSchool=c.IdSchool AND IdWorker=?;");
        stmt.setInt(1,id);

        rs = stmt.executeQuery();

        while (rs.next()){
            worker = new Worker(rs.getInt("IdWorker"),rs.getInt("Age"),rs.getString("Lastname"),rs.getString("Name"), rs.getInt("IdSchool"), rs.getInt("Salary"));

        }

        return worker;

    }

    public Collection<Worker> selectAll() throws SQLException{
        Collection<Worker> workers = new ArrayList<Worker>();
        connect();
        ResultSet rs = null;
        Statement stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT w.IdWorker, w.Age,w.Lastname,w.Name,w.Salary,c.Name AS Name_company FROM workers w, school c WHERE w.IdSchool=c.IdSchool ;");
        while(rs.next()){

            Worker w1 = new Worker(rs.getInt("IdWorker"),rs.getInt("Age"),rs.getString("Lastname"),rs.getString("Name"), rs.getInt("IdSchool"), rs.getInt("Salary"));
            workers.add(w1);
        }

        return workers;
    }

    public void editWorker(Worker worker) throws SQLException{
        connect();
        PreparedStatement stmt = conn.prepareStatement("UPDATE workers SET Surname=?,Name=?,Lastname=?,Age=?,Salary=?,Experience=?, CodeCompany=? WHERE Id_worker=?;");

        stmt.setInt(1,worker.getId());
        stmt.setInt(2,worker.getAge());
        stmt.setString(3,worker.getLastName());
        stmt.setString(4,worker.getFirstName());
        stmt.setInt(5,worker.getSalary());
        stmt.setInt(6,worker.getSchoolId());
        stmt.setInt(7,worker.getId());


        stmt.executeUpdate();
    }


    public void deleteWorker(int id) throws SQLException{
        connect();
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM workers WHERE IdWorker=?;");
        stmt.setInt(1,id);
        stmt.executeUpdate();

    }

}