<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Cool10
  Date: 07.12.2021
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Filter Company</title>
    <link rel="stylesheet" href = "CSS/bootstrap.css" type="text/css">
</head>
<body style="background-color: #49aaf5">
<h1>Companies which are located at ${IdRegion}</h1>
<h1 align="center" style="color: red; font-size: 28px">${NotFound}</h1>
<table class="table">
    <tr>
        <td scope="col"><h5>Name school</h5></td>
        <td scope="col"><h5>Phone number</h5></td>
        <td scope="col"><h5>Name city</h5></td>
    </tr>

    <c:forEach items="${companies}" var="school">
        <tr>
            <td>${company.getName()}</td>
            <td>${company.getPhoneNum()}</td>
            <td>${company.getIdRegion()}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
</body>
</html>
