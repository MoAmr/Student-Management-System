<%@ page language="java" contentType="text/html" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
    <title>Display Location</title>
</head>
<body>
<h2>Locations:</h2>
<table>
    <tr>
        <th>id</th>
        <th>code</th>
        <th>name</th>
        <th>type</th>
    </tr>

    <c:forEach var="location" items="${locations}">
        <tr>
            <td>${location.id}</td>
            <td>${location.code}</td>
            <td>${location.name}</td>
            <td>${location.type}</td>
            <td><a href="deleteLocation?id=${location.id}">Delete</a></td>
            <td><a href="showUpdate?id=${location.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
<a href="showCreate">Add Location</a>
</body>
</html>