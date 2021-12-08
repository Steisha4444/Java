nes (29 sloc)  967 Bytes
<%@ page import="DatabaseConnection.RegionManager" %>
<%@ page import="Models.Region" %><%--
  Created by IntelliJ IDEA.
  User: Cool10
  Date: 07.12.2021
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager Add city</title>
</head>
<body>
<%
    String nameCity = request.getParameter("nameCity");
    RegionManager cityManager = new RegionManager("jdbc:mysql://localhost:3306/webApp", "user", "Anastasiia");
    if(!nameCity.isEmpty()){
       Region city = new Region(nameCity);
        cityManager.addRegion(city);
        response.sendRedirect("/test/AllRegions");}
    else {
        request.setAttribute("incorrect_data","Field cannot be empty");
        RequestDispatcher rd = request.getRequestDispatcher("AddRegion.jsp");
        rd.forward(request,response);
    }
%>
</body>
</html>
