<%@ page import="DatabaseConnection.RegionManager";
<%@ page import="Models.School" %>
<%@ page import="DatabaseConnection.SchoolManager" %><%--
  Created by IntelliJ IDEA.
  User: Cool10
  Date: 07.12.2021
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager add company</title>
</head>
<body>
<%
    RegionManager cityManager = new RegionManager("jdbc:mysql://localhost:3306/webApp", "user", "Shved Anastasiia");
    String name = request.getParameter("nameCompany");
    String phone = request.getParameter("phoneCompany");
    int codeCity=0;
    String nameCity = request.getParameter("cityid");
    codeCity = cityManager.getIdRegionByName(nameCity);
    if(name.isEmpty() || phone.isEmpty()){
        request.setAttribute("incorrect_data","Fields cannot be empty");
        RequestDispatcher rd = request.getRequestDispatcher("/AddSchool");
        rd.forward(request,response);
    }
    else {
        School company = new School(name, phone, codeCity);
        SchoolManager companyManager = new SchoolManager("jdbc:mysql://localhost:3306/webApp", "user", "Shved Anastasiia");
        companyManager.addSchool(company);
        response.sendRedirect("/test//AllCompanies");
    }
%>
</body>
</html>
