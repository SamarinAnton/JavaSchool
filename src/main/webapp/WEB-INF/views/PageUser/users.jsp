<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Actions with users</title>
</head>
<body>
<h1>Select action, which you need</h1>
<ul>
    <li><a href="${pageContext.request.contextPath}/admin/users/showAll"
           title='All users'>Show all users</a></li>

    <br>
    <form:form method="post" modelAttribute="userDTO" action="/admin/users/showById">
        <form:label path="id">Find by id</form:label>
        <form:input path="id" size="4" />
        <input type="submit" value="Submit"/>
    </form:form>

    <form:form method="post" modelAttribute="userDTO" action="/admin/users/showByLogin">
        <form:label path="login">Find by login</form:label>
        <form:input path="login" size="11"/>
        <input type="submit" value="Submit"/>
    </form:form>

    <li><a href="${pageContext.request.contextPath}/admin/users/add"
           title='Add new user'>Add new user</a></li>
    <br>
    <br>
    <li><a href="${pageContext.request.contextPath}/admin/"
           title='Back'>Back</a></li>
</ul>

</body>
</html>
