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

@WebServlet(name = "AllSchoolsServlet", value = "/AllSchools")
public class AllSchoolsServlet extends HttpServlet {

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
        cityManager = new RegionManager(url,user,pass);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Collection<School> companies = null;
        Collection<String> names = null;

        try {
            companies = companyManager.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            names = cityManager.getAllNames();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("schools",companies);
        request.setAttribute("regions",names);

        RequestDispatcher rd = request.getRequestDispatcher("AllSchools.jsp");
        rd.forward(request,response);
    }


}