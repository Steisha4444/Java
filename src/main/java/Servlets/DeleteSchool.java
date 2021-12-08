package Servlets;

import Models.School;

import DatabaseConnection.SchoolManager;
import DatabaseConnection.WorkerManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteSchool", value = "/DeleteSchool")
public class DeleteSchool extends HttpServlet {


    private SchoolManager companyManager;
    private String url;
    private String user;
    private String pass;

    @Override
    public void init(){
        url = "jdbc:mysql://localhost:3306/webApp";
        user = "user";
        pass = "Shved Anastasiia";

        companyManager = new SchoolManager(url,user,pass);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("deleteIdSchool"));
        try {
            companyManager.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/test/AllSchools");

    }
}