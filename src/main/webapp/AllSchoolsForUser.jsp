<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Cool10
  Date: 07.12.2021
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Schools</title>
    <link rel="stylesheet" href = "CSS/bootstrap.css" type="text/css">
</head>
<body>
<jsp:include page="logout.jsp"></jsp:include>
<jsp:include page="navForGuest.jsp"></jsp:include>
<h1>List of all schools</h1>
<h4>Filter workers</h4>
<form action="./FilterByRegion" method="post">
    <tr>
        <td>
            <select name="filterByCity">
                <option disabled="Choose name city">Choose name Region</option>
                <c:forEach items="${listcity}" var="listcity">
                    <option value="${listcity}">${listcity}</option>
                </c:forEach>
            </select>
        </td>
        <td>
            <input type="submit" value="Search by city" class="btn btn-info">
        </td>
    </tr>
</form>
<br/>
<table class="table">
    <tr>
        <td scope="col"><h5>Name School</h5></td>
        <td scope="col"><h5>Phone number</h5></td>
        <td scope="col"><h5>Name of region</h5></td>
    </tr>

    <c:forEach items="${companies}" var="company">
        <tr>
            <td>${company.getName()}</td>
            <td>${company.getPhoneCompany()}</td>
            <td>${company.getNameCity()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
