<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>All users</title>
</head>
<body>
<h1>All users</h1>
<table class="AllUsers">
    <thead>
    <tr>
        <th>id</th>
        <th>login</th>
        <th>password</th>
    </tr>
    </thead>

    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.login}</td>
            <td>
                <c:if test="${user.status == 'DRIVER'}">
                    ${user.password}
                </c:if>
                <c:if test="${user.status == 'ADMIN'}">
                    ***
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<li><a href="${pageContext.request.contextPath}/admin/users"
       title='Cargoes'>Back</a></li>
</body>
</html>
