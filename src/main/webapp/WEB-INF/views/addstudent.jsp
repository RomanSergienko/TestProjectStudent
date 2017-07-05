<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add student</title>
</head>
<body>
<a href="index.jsp">Back to main</a>
<h2>Add student</h2>

<form:form method="POST" action="addstudent" modelAttribute="student">
    <table>
        <tr>
            <td><form:label path="groupId">GroupId</form:label></td>
            <td><form:input path="groupId"/></td>
        </tr>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="surName">SurName</form:label></td>
            <td><form:input path="surName"/></td>
        </tr>
        <tr>
            <td><form:label path="ratingEge">Rating EGE</form:label></td>
            <td><form:input path="ratingEge"/></td>
        </tr>
        <tr>
            <td><form:label path="enrolmentDate">Enrolment Date</form:label></td>
            <td><form:input path="enrolmentDate"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
