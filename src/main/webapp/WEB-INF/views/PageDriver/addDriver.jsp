<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add city</title>
</head>
<body>

<h1>Enter information about city</h1>
<form:form method="post" modelAttribute="driverDTO" action="/admin/drivers/add/driver">
    <table>
        <tr>
            <td><form:label path="number">Number</form:label></td>
            <td><form:input path="number" /></td>
        </tr>
        <tr>
            <td><form:label path="firstName">First name</form:label></td>
            <td><form:input path="firstName" /></td>
        </tr>
        <tr>
            <td><form:label path="lastName">Last name</form:label></td>
            <td><form:input path="lastName" /></td>
        </tr>
        <tr>
            <td><form:label path="city">Name of city</form:label></td>
            <td><form:input path="city" /></td>
        </tr>
        <tr>
            <td><form:label path="user">Name of user</form:label></td>
            <td><form:input path="user" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>