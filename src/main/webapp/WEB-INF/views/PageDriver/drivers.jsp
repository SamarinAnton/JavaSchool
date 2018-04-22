<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Actions with cities</title>
</head>
<body>
<h1>Select action, which you need</h1>
<ul>
    <li><a href="${pageContext.request.contextPath}/admin/drivers/showAll"
           title='Cities'>Show all drivers</a></li>
    <li><a href="${pageContext.request.contextPath}/admin/drivers/showById"
           title='Drivers'>Show drivers by id</a></li>
    <li><a href="${pageContext.request.contextPath}/admin/drivers/showByName"
           title='Vehicles'>Show city by name</a></li>
    <li><a href="${pageContext.request.contextPath}/admin/drivers/add"
           title='Users'>Add new driver</a></li>
    <li><a href="${pageContext.request.contextPath}/admin/drivers/distance"
           title='Orders'>What is length between cities</a></li>
    <li><a href="${pageContext.request.contextPath}/admin/"
           title='Cargoes'>Back</a></li>
</ul>

</body>
</html>
