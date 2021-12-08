<%--
  Created by IntelliJ IDEA.
  User: Cool10
  Date: 07.12.2021
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Editing school</title>
    <link rel="stylesheet" href = "CSS/bootstrap.css" type="text/css">
</head>
<body>
<h2 align="center">Change information about School</h2>
<br/><br/><br/>
<form action="./ManagerEditSchool.jsp" method="post">
    <table align="center" style="background-color: #9fcdff">
        <tr>
            <td><h4>Current name School</h4></td>
            <td><input type = "text" name="nameCompany" value="${schoolName}" style=" border-radius: 4px; font-size: 22px"></td>
        </tr>
        <tr>
            <td><h4>Current phone number</h4></td>
            <td><input type="text" name="phoneCompany" value="${schoolPhone}" style=" border-radius: 4px; font-size: 22px"></td>
        </tr>
        <tr>
            <td><h4>Current name city</h4></td>
            <td><h4>${IdRegion}</h4></td>
        </tr>
        <tr>
            <td><h4>Change name city if you want</h4></td>
            <td><select name="codeCity" style=" border-radius: 4px; font-size: 22px">
                <option disabled="Choose code city">Choose id city</option>
                <option value="${IdRegion}">${IdRegion}</option>
                <c:forEach items="${IdRegion}" var="codes">
                    <option value="${codes}">${codes}</option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td><input type="submit" value="Save changes" class="btn btn-success"></td>
        </tr>
        <input type ="hidden" name="idSchool" value="${IdSchool}">
    </table>
</form>
</body>
</html>