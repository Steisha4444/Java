<%@ page import="Models.Worker" %>
<%@ page import="DatabaseConnection.WorkerManager" %>
<%@ page import="java.util.Collection" %>
<%@ page import="Models.School" %>
<%@ page import="DatabaseConnection.SchoolManager" %><%--
  Created by IntelliJ IDEA.
  User: Cool10
  Date: 07.12.2021
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager Add Worker</title>
</head>
<body>

<%
    SchoolManager companyManager = new SchoolManager("jdbc:mysql://localhost:3306/webApp", "user", "Shved Anastasiia");
    String name = request.getParameter("nameWorker");
    String lastname = request.getParameter("lastnameWorker");
    String nameCompany = request.getParameter("IdSchool");
    int age = 0;
    int salary = 0;
    int idCompany = 0;
    if(!request.getParameter("IdRegion").isEmpty()){
        idCompany = Integer.parseInt(request.getParameter("IdRegion"));}
    if(!request.getParameter("ageWorker").isEmpty()){
        age = Integer.parseInt(request.getParameter("ageWorker"));}
    if(!request.getParameter("salaryWorker").isEmpty()){
        salary = Integer.parseInt(request.getParameter("salaryWorker"));}
     if(lastname.isEmpty() || name.isEmpty() || age == 0 || salary==0 ){
        request.setAttribute("incorrect_data","Fields cannot be empty");
        RequestDispatcher rd = request.getRequestDispatcher("/AddWorker");
        rd.forward(request,response);
    }
    else {
        Worker worker = new Worker(44,age, lastname, name, salary, idCompany);
        WorkerManager workerManager = new WorkerManager("jdbc:mysql://localhost:3306/webApp", "user", "Shved Anastasiia");
        workerManager.addWorkerToTable(worker);
        response.sendRedirect("/test/AllWorkers");
    }
%>

</body>
</html>
