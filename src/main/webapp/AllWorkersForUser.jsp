
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Cool10
  Date: 07.12.2021
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Workers</title>
    <link rel="stylesheet" href = "CSS/bootstrap.css" type="text/css">
</head>
<body>
<jsp:include page="logout.jsp"></jsp:include>
<jsp:include page="navForGuest.jsp"></jsp:include>
<h1>List of all workers</h1>
<table class="table">
    <h4>Filter workers</h4>
    <form action="./FilterByAge" method="post">
        <tr>
            <td>
                <select name="filterByAge">
                    <option value="<25"><25</option>
                    <option value="25-40">25-40</option>
                    <option value="40-55">40-55</option>
                    <option value="55-60">55-60</option>
                </select>
            </td>
            <td>
                <input type="submit" value="Search by age" class="btn btn-info">
            </td>
        </tr>
    </form>
    <br/>
    <form action="./FilterBySalary" method="post">
        <tr>
            <td>
                <select name="filterBySalary">
                    <option value="<17000"><17000</option>
                    <option value="17000-25000">17000-25000</option>
                    <option value="25000-35000">25000-35000</option>
                    <option value=">35000">>35000</option>
                </select>
            </td>
            <td>
                <input type="submit" value="Search by salary" class="btn btn-info">
            </td>
        </tr>
    </form>
    <br/>
    <form action="./FilterBySchool" method="post">
        <tr>
            <td>
                <select name="filterBySchool">
                    <option disabled="Choose name company">Choose name company</option>
                    <c:forEach items="${school}" var="school">
                        <option value="${school}">${school}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <input type="submit" value="Search by company" class="btn btn-info">
            </td>
        </tr>
    </form>
    <tr>
        <td scope="col"><h5>ID worker</h5></td>
        <td scope="col"><h5>Age worker</h5></td>
        <td scope="col"><h5>Lastname worker</h5></td>
        <td scope="col"><h5>name worker</h5></td>
        <td scope="col"><h5>Salary worker</h5></td>
        <td scope="col"><h5>Name School</h5></td>
    </tr>

    <c:forEach items="${workers}" var="worker">
        <tr>
            <td>${worker.getId()}</td>
            <td>${worker.getAge()}</td>
            <td>${worker.getLastName()}</td>
            <td>${worker.getName()}</td>
            <td>${worker.getSalary()}</td>
            <td>${worker.getNameCompany()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>