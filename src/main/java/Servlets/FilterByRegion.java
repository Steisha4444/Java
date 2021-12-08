package Servlets;

import DatabaseConnection.RegionManager;
import DatabaseConnection.SchoolManager;
import DatabaseConnection.WorkerManager;
import Models.School;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

@WebServlet(name = "FilterByRegion", value = "/FilterByRegion")
public class FilterByRegion extends HttpServlet {
    private SchoolManager companyManager;
    private RegionManager cityManager;
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
        String nameCity = request.getParameter("filterByRegion");
        Collection<School> companies = null;

        try {
            companies = companyManager.selectSchoolByRegion(nameCity);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(!companies.isEmpty()) {
            request.setAttribute("nameRegion", nameCity);
            request.setAttribute("school",companies);
            RequestDispatcher rd = request.getRequestDispatcher("FilterSchool.jsp");
            rd.forward(request,response);
        }

        else{
            request.setAttribute("nameRegion", nameCity);
            request.setAttribute("NotFound","Not found schools at "+nameCity);
            RequestDispatcher rd = request.getRequestDispatcher("FilterSchool.jsp");
            rd.forward(request, response);
        }
    }
}