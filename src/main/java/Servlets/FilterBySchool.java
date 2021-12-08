package Servlets;

import DatabaseConnection.WorkerManager;
import Models.Worker;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

@WebServlet(name = "FilterBySchool", value = "/FilterBySchool")
public class FilterBySchool extends HttpServlet {
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
        String name = request.getParameter("filterBySchool");
        Collection<Worker> workers = null;

        try {
            workers = workerManager.filterBySchool(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(workers.isEmpty()){
            request.setAttribute("school","Workers which work in school "+name);
            request.setAttribute("NotFound","Not found workers who work in this school "+name);
            RequestDispatcher rd = request.getRequestDispatcher("WorkerFilter.jsp");
            rd.forward(request, response);
        }
        else {
            request.setAttribute("school","Workers which work in school "+name);
            request.setAttribute("workers", workers);
            RequestDispatcher rd = request.getRequestDispatcher("WorkerFilter.jsp");
            rd.forward(request, response);

        }
    }
}