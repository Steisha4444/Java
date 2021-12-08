package Servlets;

import DatabaseConnection.RegionManager;
import DatabaseConnection.SchoolManager;
import Models.Region;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

@WebServlet(name = "AllRegions", value = "/AllRegions")
public class AllRegions extends HttpServlet {

    private RegionManager cityManager;
    private String url;
    private String user;
    private String pass;

    @Override
    public void init(){
        url = "jdbc:mysql://localhost:3306/webApp";
        user = "user";
        pass = "Shved Anastasiia";

        cityManager = new RegionManager(url,user,pass);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Collection<Region> cities = null;

        try {
            cities = cityManager.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("regions",cities);
        RequestDispatcher rd = request.getRequestDispatcher("AllRegions.jsp");
        rd.forward(request,response);

    }

}