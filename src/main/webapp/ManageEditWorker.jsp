<%@ page import="Models.Worker" %>
<%@ page import="DatabaseConnection.WorkerManager" %>
<%@ page import="DatabaseConnection.SchoolManager" %>
<%@ page import="Models.School" %><%--
<%--
  Created by IntelliJ IDEA.
  User: Cool10
  Date: 07.12.2021
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage edit worker</title>
</head>
<body>
<%
    int idWorker = Integer.parseInt(request.getParameter("idWorker"));
    int age = Integer.parseInt(request.getParameter("ageWorker"));
    String lastname = request.getParameter("lastnameWorker");
    String name = request.getParameter("nameWorker");
    int salary = Integer.parseInt(request.getParameter("salaryWorker"));
    int experience = Integer.parseInt(request.getParameter("experienceWorker"));
    String nameCompany = request.getParameter("codeCompany");
    SchoolManager companyManager = new SchoolManager("jdbc:mysql://localhost:3306/webApp","user","Shved Anastasiia");
    int idCompany = companyManager.getIdByName(nameCompany);
    Worker worker = new Worker(idWorker,age,lastname,name,salary,idCompany);
    WorkerManager workerManager = new WorkerManager("jdbc:mysql://localhost:3306/webApp","user","Shved Anastasiia");
    workerManager.editWorker(worker);
    response.sendRedirect("/test/AllWorkers");
%>
</body>
</html>
