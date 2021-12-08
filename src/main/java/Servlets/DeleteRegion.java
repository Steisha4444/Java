package Servlets;

import DatabaseConnection.RegionManager;
import DatabaseConnection.SchoolManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteRegion", value = "/DeleteRegion")
public class DeleteRegion extends HttpServlet {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("deleteIdRegion"));

        try {
            cityManager.deleteRegion(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/test/AllRegions");
    }
}