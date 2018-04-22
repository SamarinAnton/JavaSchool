<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<h2>User information</h2>
<table class="User">
        <tr>
            <td>Id</td>
            <td>${user.id}</td>
        </tr>
        <tr>
            <td>Login</td>
            <td>${user.login}</td>
        </tr>
        <tr>
            <td>Password</td>
            <td>
                <c:if test="${user.status == 'DRIVER'}">
                    ${user.password}
                </c:if>
                <c:if test="${user.status == 'ADMIN'}">
                    ***
                </c:if>
            </td>
        </tr>
        <tr>
            <td>Status</td>
            <td>${user.status}</td>
        </tr>
</table>
<br>
<li><a href="${pageContext.request.contextPath}/admin/users"
       title='Cargoes'>Back</a></li>
</body>
</html>
