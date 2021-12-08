<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add city</title>
    <link rel="stylesheet" href = "CSS/bootstrap.css" type="text/css">
</head>
<body>
<h1 align="center">Adding new Region</h1>
<br/><br/><br/>

<h1 align="center" style="color: red">${incorrect_data}</h1>
<form action="./ManagerAddRegion.jsp" method="post">
    <table align="center" style="background-color: #9fcdff">
        <tr>
            <td><h4>Name Region</h4></td>
            <td><input type="text" name="nameRegion" style=" border-radius: 4px; font-size: 22px"></td>
        </tr>

        <tr>
            <td><input type="submit" value="Add city" class="btn btn-success"></td>
        </tr>
    </table>
</form>

</body>
</html>