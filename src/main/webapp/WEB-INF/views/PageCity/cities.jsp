<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Actions with cities</title>
</head>
<body>
<h1>Select action, which you need</h1>
<ul>
    <li><a href="${pageContext.request.contextPath}/admin/cities/showAll"
           title='All cities'>Show all cities</a></li>

    <form:form method="post" modelAttribute="cityDTO" action="/admin/cities/showById">
        <form:label path="id">Find by id</form:label>
        <form:input path="id" size="4" />
        <input type="submit" value="Submit"/>
    </form:form>

    <form:form method="post" modelAttribute="cityDTO" action="/admin/cities/showByName">
        <form:label path="name">Find by name</form:label>
        <form:input path="name" size="11"/>
        <input type="submit" value="Submit"/>
    </form:form>

    <li><a href="${pageContext.request.contextPath}/admin/cities/add"
           title='Add new city'>Add new city</a></li>
    <br>
    <li><a href="${pageContext.request.contextPath}/admin/"
           title='Back'>Back</a></li>
</ul>

</body>
</html>
