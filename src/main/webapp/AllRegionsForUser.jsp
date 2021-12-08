<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Cool10
  Date: 07.12.2021
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All cities</title>
    <link rel="stylesheet" href = "CSS/bootstrap.css" type="text/css">
</head>
<body>
<jsp:include page="logout.jsp"></jsp:include>
<jsp:include page="navForGuest.jsp"></jsp:include>
<h1>List of all available cities</h1>

<table class="table">
    <tr>
        <td scope="col" align="center"><h5>Name Region</h5></td>
    </tr>

    <c:forEach items="${cities}" var="city">
        <tr>
            <td align="center">${city.getName()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>