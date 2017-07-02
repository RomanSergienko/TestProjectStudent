<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Students</title>
</head>
<body>
<a href="index.jsp">Back to main</a>
<h2>Users List</h2>

<div style="float:left; margin:5px;">
    <td><a href=""><< Previous</a></td>
    <td><a href="">Next >></a></td>
</div>

<div style="float:left; margin:5px;">
    <form method="get">
        <input type="number" min="1" max="100">
        <input type="submit" value="Go to"/>
    </form>
</div>

<div style="float:left; margin:5px;">Pages: ${allpage}</div>

<c:if test="${!empty listStudents}">
<table border="1" width="90%">
    <tr>
        <th>Id</th>
        <th>GroupId</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Rating Ege</th>
        <th>Enrolment Date</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${listStudents}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.groupId}</td>
            <td>${student.name}</td>
            <td>${student.surName}</td>
            <td>${student.ratingEge}</td>
            <td>${student.enrolmentDate}</td>
            <td><a href="<c:url value="/delete/${student.id}"/>">Delete</a></td>
            <td><a href="<c:url value="/edit/${student.id}"/>">Edit</a></td>
        </tr>
        </c:forEach>
</table>
</c:if>
</body>
</html>