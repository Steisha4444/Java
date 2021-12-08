<%@ page import="DatabaseConnection.UserManager" %><%--
  Created by IntelliJ IDEA.
  User: Cool10
  Date: 07.12.2021
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String role = request.getParameter("whichRole");
    int id = Integer.parseInt(request.getParameter("currentId"));
    UserManager userManager = new UserManager("jdbc:mysql://localhost:3306/webApp", "user", "Shved Anastasiia");
    userManager.updateRole(role,id);
    response.sendRedirect("/test/AllUsers");
%>
</body>
</html>