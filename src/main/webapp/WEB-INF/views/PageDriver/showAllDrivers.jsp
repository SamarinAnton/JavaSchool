<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>All drivers</title>
</head>
<body>
<h1>All drivers</h1>
<table class="table drivers">
    <thead>
    <tr>
        <th>id</th>
        <th>number</th>
        <th>first name</th>
        <th>last name</th>
        <th>status</th>
        <th>worked</th>
        <th>last update</th>
    </tr>
    </thead>

    <c:forEach var="driver" items="${drivers}">
        <tr>
            <td>${driver.id}</td>
            <td>${driver.number}</td>
            <td>${driver.firstName}</td>
            <td>${driver.lastName}</td>
            <td>${driver.status}</td>
            <td>${driver.worked}</td>
            <td>${driver.update}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
