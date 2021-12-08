package Servlets;

import DatabaseConnection.SchoolManager;
import Models.School;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

@WebServlet(name = "AddWorker", value = "/AddWorker")
public class AddWorker extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<String> companies = null;
        SchoolManager companyManager = new SchoolManager("jdbc:mysql://localhost:3306/webApp", "user","Shved Anastasiia");
        try {
            companies = companyManager.getAllNames();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("schoolsId",companies);
        RequestDispatcher rd = request.getRequestDispatcher("AddWorker.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<String> companies = null;
        SchoolManager companyManager = new SchoolManager("jdbc:mysql://localhost:3306/webApp", "user","Shved Anastasiia");
        try {
            companies = companyManager.getAllNames();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("schoolsId",companies);
        RequestDispatcher rd = request.getRequestDispatcher("AddWorker.jsp");
        rd.forward(request,response);
    }
}