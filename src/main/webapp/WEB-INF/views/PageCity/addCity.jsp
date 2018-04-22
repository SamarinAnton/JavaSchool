<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add city</title>
</head>
<body>

<h1>Enter information about city</h1>
<form:form method="post" modelAttribute="cityDTO" action="/admin/cities/add/city">
    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td><form:label path="latitude">Latitude</form:label></td>
            <td><form:input path="latitude" /></td>
        </tr>
        <tr>
            <td><form:label path="longitude">Longitude</form:label></td>
            <td><form:input path="longitude" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>
<br>
<li><a href="${pageContext.request.contextPath}/admin/cities"
       title='Back'>Back</a></li>
</body>
</html>