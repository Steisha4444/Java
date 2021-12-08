package Servlets;

import DatabaseConnection.RegionManager;
import DatabaseConnection.SchoolManager;
import DatabaseConnection.WorkerManager;
import Models.Region;
import Models.School;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

@WebServlet(name = "EditSchool", value = "/EditSchool")
public class EditSchool extends HttpServlet {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        School company = null;
        Collection<String> cities = null;
        int id = Integer.parseInt(request.getParameter("editIdCompany"));

        try {
            company = companyManager.getSchoolById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            cities = cityManager.getAllNames();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("companyId",company.getId());
        request.setAttribute("companyName",company.getName());
        request.setAttribute("companyPhone",company.getPhoneNum());
        request.setAttribute("codeRegion",company.getIdRegion());
        request.setAttribute("codesRegions",cities);

        RequestDispatcher rd = request.getRequestDispatcher("EditSchool.jsp");
        rd.forward(request,response);

    }
}