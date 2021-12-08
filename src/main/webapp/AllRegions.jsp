<%--
  Created by IntelliJ IDEA.
  User: Cool10
  Date: 07.12.2021
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Regions</title>
    <link rel="stylesheet" href = "CSS/bootstrap.css" type="text/css">
</head>
<body>
<jsp:include page="logout.jsp"></jsp:include>
<jsp:include page="navForAdmin.jsp"></jsp:include>
<h1>List of all available Regions</h1>

<table class="table">
    <tr>
        <td scope="col"><h5>ID Region</h5></td>
        <td scope="col"><h5>Name Region</h5></td>
    </tr>

    <c:forEach items="${cities}" var="city">
        <tr>
            <td>${city.getId()}</td>
            <td>${city.getName()}</td>
            <td>
                <form action="./DeleteRegion?id=${city.getId()}" method="post">
                    <input type="hidden" name="deleteIdCity" value="${city.getId()}">
                    <input type="submit" value="Delete" class="btn btn-danger">
                </form>
            </td>
        </tr>
    </c:forEach>
    <button><a href="./AddRegion.jsp" style="text-decoration: none">Add Region</a> </button>
</table>
</body>
</html>