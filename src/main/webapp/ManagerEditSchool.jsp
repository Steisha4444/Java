<%@ page import="Models.School" %>
<%@ page import="DatabaseConnection.SchoolManager" %>
<%@ page import="DatabaseConnection.RegionManager" %><%--
  Created by IntelliJ IDEA.
  User: Cool10
  Date: 07.12.2021
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager edit School</title>
</head>
<body>
<%
    int id = Integer.parseInt(request.getParameter("idCompany"));
    String name = request.getParameter("nameCompany");
    String phone = request.getParameter("phoneCompany");
    String nameCity = request.getParameter("codeCity");
    RegionManager cityManager = new RegionManager("jdbc:mysql://localhost:3306/webApp", "user", "Shved Anastasiia");
    int idCity = cityManager.getIdRegionByName(nameCity);
    School company = new School(id, name, phone, idCity);
    SchoolManager companyManager = new SchoolManager("jdbc:mysql://localhost:3306/webApp", "user", "Shved Anastasiia");
    companyManager.editSchool(company);
    response.sendRedirect("/test/AllCompanies");
%>


</body>
</html>
