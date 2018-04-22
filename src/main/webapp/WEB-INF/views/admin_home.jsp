<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Home</title>
</head>
<body>
    <h1>Select category</h1>
    <ul>
        <li><a href="${pageContext.request.contextPath}/admin/cities"
               title='Cities'>Actions with cities</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/drivers"
               title='Drivers'>Actions with drivers</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/vehicles"
               title='Vehicles'>Actions with vehicles</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/users"
               title='Users'>Actions with users</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/orders"
               title='Orders'>Actions with orders</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/cargoes"
               title='Cargoes'>Actions with cargoes</a></li>
    </ul>

</body>
</html>
