<%--
  Created by IntelliJ IDEA.
  User: Cool10
  Date: 07.12.2021
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add School</title>
    <link rel="stylesheet" href = "CSS/bootstrap.css" type="text/css">
</head>
<body>
<h1 align="center">Adding new school</h1>
<br/><br/><br/>

<h1 align="center" style="color: red">${incorrect_data}</h1>
<form action="./ManagerAddSchool.jsp" method="post">
    <table align="center" style="background-color: #9fcdff">
        <tr>
            <td><h4>Name School</h4></td>
            <td><input type="text" name="nameSchool" style=" border-radius: 4px; font-size: 22px"></td>
        </tr>
        <tr>
            <td><h4>Phone Number</h4></td>
            <td><input type="text" name="phoneNumber" style=" border-radius: 4px; font-size: 22px"></td>
        </tr>
        <tr>
            <td><h4>NameRegion</h4></td>
            <td>
                <select name="IdRegion" style=" border-radius: 4px; font-size: 22px">
                    <option disabled>Choose name city</option>
                    <c:forEach items="${citiesId}" var="citiid">
                        <option value="${citiid}">${citiid}</option>
                    </c:forEach>
                </select></td>
        </tr>
        <tr>
            <td><input type="submit" value="Add school" class="btn btn-success"></td>
        </tr>
    </table>
</form>

</body>
</html>