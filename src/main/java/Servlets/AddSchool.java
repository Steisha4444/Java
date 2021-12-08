package Servlets;


import DatabaseConnection.RegionManager;
import DatabaseConnection.SchoolManager;
import Models.Region;
import Models.School;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

@WebServlet(name = "AddSchool", value = "/AddSchool")
public class AddSchool extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<String> cities = null;
        RegionManager cityManager = new RegionManager("jdbc:mysql://localhost:3306/webApp", "user","Shved Anastasiia");
        try {
            cities = cityManager.getAllNames();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("regionsId",cities);
        RequestDispatcher rd = request.getRequestDispatcher("AddSchool.jsp");
        rd.forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<String> cities = null;
        RegionManager cityManager = new RegionManager("jdbc:mysql://localhost:3306/webApp", "user","Shved Anastasiia");
        try {
            cities = cityManager.getAllNames();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("regionsId",cities);
        RequestDispatcher rd = request.getRequestDispatcher("AddSchool.jsp");
        rd.forward(request,response);
    }


}