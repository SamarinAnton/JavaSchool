<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>

<h1>Enter information about city</h1>
<form:form method="post" modelAttribute="userDTO" action="/admin/users/add/user">
    <table>
        <tr>
            <td><form:label path="login">Login</form:label></td>
            <td><form:input path="login" /></td>
        </tr>
        <tr>
            <td><form:label path="password">Password</form:label></td>
            <td><form:input path="password" /></td>
        </tr>
        <tr>
            <td>Status :</td>
            <td><form:radiobutton path="status" value="ADMIN" label="Admin" />
                <form:radiobutton path="status" value="DRIVER" label="Driver" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>
<br>
<li><a href="${pageContext.request.contextPath}/admin/users"
       title='Cargoes'>Back</a></li>
</body>
</html>