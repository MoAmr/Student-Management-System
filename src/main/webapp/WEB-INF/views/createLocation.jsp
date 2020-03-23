<%@ page language="java" contentType="text/html" pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
    <title>Create Location</title>
</head>
<body>
<form action="saveLocation" method="post">
    <pre>
    Id: <input type="text" name="id"/>
    Code: <input type="text" name="code"/>
    Name: <input type="text" name="name"/>
    Type: Urban <input type="radio" name="type" value="URBAN"/>
        Rural <input type="radio" name="type" value="RURAL"/>
    <input type="submit" value="save"/>
    </pre>
</form>
${msg}

<a href="displayLocations">View All</a>
</body>
</html>