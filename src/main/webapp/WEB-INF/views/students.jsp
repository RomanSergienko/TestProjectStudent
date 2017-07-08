<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Students</title>
</head>
<body>
<a href="../../index.jsp">Back to main</a>
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
        <th>Delete</th>
        <th>Edit</th>
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
<h2>Add/Edit student</h2>
<c:url var="addAction" value="/students/add"/>
<form:form action="${addAction}" commandName="student">
    <table>
        <c:if test="${!empty student.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="groupId">
                    <spring:message text="GroupId"/>
                </form:label>
            </td>
            <td>
                <form:input path="groupId"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="surName">
                    <spring:message text="Surname"/>
                </form:label>
            </td>
            <td>
                <form:input path="surName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="ratingEge">
                    <spring:message text="Rating EGE"/>
                </form:label>
            </td>
            <td>
                <form:input path="ratingEge"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="enrolmentDate">
                    <spring:message text="Enrolment Date"/>
                </form:label>
            </td>
            <td>
                <form:input path="enrolmentDate"/>
            </td>
        </tr>
        <tr>
        <tr>
            <td>
                <c:if test="${!empty student.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Student"/>"/>
                </c:if>
                <c:if test="${empty student.name}">
                    <input type="submit"
                           value="<spring:message text="Add Student"/>"/>
                </c:if>
            </td>
        </tr>
        </tr>
    </table>
</form:form>
</body>
</html>