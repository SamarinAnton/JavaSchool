<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>All cities</title>
</head>
<body>
    <h1>All cities</h1>
    <h3>For more information look for city by id or name</h3>
    <table class="AllCities">
        <thead>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>latitude</th>
            <th>longitude</th>
        </tr>
        </thead>

        <c:forEach var="city" items="${cities}">
            <tr>
                <td>${city.id}</td>
                <td>${city.name}</td>
                <td>${city.latitude}</td>
                <td>${city.longitude}</td>
            </tr>
        </c:forEach>
    </table>
    <br>

    <li><a href="${pageContext.request.contextPath}/admin/cities"
           title='Back'>Back</a></li>
</body>
</html>
