<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Users</title>
</head>
<body>
<a href="index.jsp">Back to main</a>
<h1>Users List</h1>

<c:if test="${!empty listStudents}">
<table border="1" width="90%">
    <tr>
        <th>Id</th>
        <th>GroupId</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Rating Ege</th>
        <th>Enrolment Date</th>
    </tr>
    <c:forEach items="${listStudents}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.groupId}</td>
            <td>${student.name}</td>
            <td>${student.surName}</td>
            <td>${student.ratingEge}</td>
            <td>${student.enrolmentDate}</td>
        </tr>
        </c:forEach>
</table>
</c:if>
</body>
</html>