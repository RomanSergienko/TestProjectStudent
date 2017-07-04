<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Student</title>
</head>
<body>
<a href="index.jsp">Back to main</a>
<h2>Edit student</h2>

<form:form method="POST" action="editstudent" modelAttribute="student">
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
