<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Users</title>
</head>
<body>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Users List</h1>


<table border="1" width="90%">
    <tr>
        <th>Id</th>
        <th>GroupId</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Rating Ege</th>
        <th>Enrolment Date</th>
    </tr>
    <c:forEach items="${list}" var="student">
    <tr>
        <td>${student.getId()}</td>
        <td>${student.getGroupId()}</td>
        <td>${student.getName()}</td>
        <td>${student.getSurName()}</td>
        <td>${student.getRatingEge()}</td>
        <td>${student.getCountry()}</td>
        </c:forEach>
</table>

</body>
</html>