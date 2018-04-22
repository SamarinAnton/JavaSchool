<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>City</title>
</head>
<body>
<h2>City information</h2>
<table class="City">
    <tr>
        <td>Id</td>
        <td>${cityDTO.id}</td>
    </tr>
    <tr>
        <td>Name</td>
        <td>${cityDTO.name}</td>
    </tr>
    <tr>
        <td>Latitude</td>
        <td>${cityDTO.latitude}</td>
    </tr>
    <tr>
        <td>Longitude</td>
        <td>${cityDTO.longitude}</td>
    </tr>
</table>
<br>
<c:if test="${driverDTO != null}">
    <h2>Drivers information</h2>
    <table class="DriversInCity">
        <thead>
        <tr>
            <th>id</th>
            <th>FirstName</th>
            <th>LastName</th>
            <th>Number</th>
            <th>worked</th>
            <th>update</th>
            <th>status</th>
            <th>Order number</th>
            <th>vehicle number</th>
        </tr>
        </thead>


        <c:forEach var="driver" items="${driverDTO}">
            <tr>
                <td>${driver.id}</td>
                <td>${driver.firstName}</td>
                <td>${driver.lastName}</td>
                <td>${driver.number}</td>
                <td>${driver.worked}</td>
                <td>${driver.update}</td>
                <td>${driver.status}</td>
                <td>${driver.number}</td>
                <c:if test="${driver.order != null}">
                    <td>${driver.order.number}</td>
                </c:if>
                <c:if test="${driver.order == null}">
                    <td>null</td>
                </c:if>
                <c:if test="${driver.vehicle != null}">
                    <td>${driver.vehicle.number}</td>
                </c:if>
                <c:if test="${driver.vehicle == null}">
                    <td>null</td>
                </c:if>
            </tr>
        </c:forEach>

    </table>
</c:if>
<c:if test="${driverDTO == null}">
    <h5>There aren't drivers in this city</h5>
</c:if>

<br>
<c:if test="${vehicleDTO != null}">
    <h2>Vehicles information</h2>
    <table class="VehiclesInCity">
        <thead>
        <tr>
            <th>id</th>
            <th>number</th>
            <th>capacity</th>
            <th>count</th>
            <th>status</th>
            <th>order number</th>
        </tr>
        </thead>

        <c:forEach var="vehicle" items="${vehicleDTO}">
            <tr>
                <td>${vehicle.id}</td>
                <td>${vehicle.number}</td>
                <td>${vehicle.capacity}</td>
                <td>${vehicle.count}</td>
                <td>${vehicle.status}</td>
                <c:if test="${vehicle.order != null}">
                    <td>${vehicle.order.number}</td>
                </c:if>
                <c:if test="${vehicle.order == null}">
                    <td>null</td>
                </c:if>
            </tr>
        </c:forEach>

    </table>
</c:if>
<c:if test="${vehicleDTO == null}">
    <h5>There aren't vehicles in this city</h5>
</c:if>

<br>
<li><a href="${pageContext.request.contextPath}/admin/cities"
       title='Back'>Back</a></li>
</body>
</html>
