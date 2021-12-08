package Servlets;

import DatabaseConnection.SchoolManager;
import DatabaseConnection.WorkerManager;
import Models.School;
import Models.Worker;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

@WebServlet(name = "EditWorker", value = "/EditWorker")
public class EditWorker extends HttpServlet {

    private WorkerManager workerManager;
    private String url;
    private String user;
    private String pass;

    @Override
    public void init(){
        url = "jdbc:mysql://localhost:3306/webApp";
        user = "user";
        pass = "Shved Anastasiia";

        workerManager = new WorkerManager(url,user,pass);
    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Worker worker = null;

        int id = Integer.parseInt(request.getParameter("editId"));


        try {
            worker=workerManager.getWorkerById(id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Collection<String> companies = null;
        SchoolManager companyManager = new SchoolManager("jdbc:mysql://localhost:3306/webApp", "user","Shved Anastasiia");
        try {
            companies = companyManager.getAllNames();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("workerId",worker.getId());
        request.setAttribute("workerAge",worker.getAge());
        request.setAttribute("workerLastName",worker.getLastName());
        request.setAttribute("workerName",worker.getFirstName());
        request.setAttribute("workerSalary",worker.getSalary());
        request.setAttribute("workerIdSchool",worker.getSchoolId());
        request.setAttribute("codesCompany",companies);

        RequestDispatcher rd = request.getRequestDispatcher("EditWorker.jsp");
        rd.forward(request,response);
    }



}