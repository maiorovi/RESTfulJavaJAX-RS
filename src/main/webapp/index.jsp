<%--
  Created by IntelliJ IDEA.
  User: egor
  Date: 2/25/2017
  Time: 18:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Hello World!</p>
<form action="/rest/customers" method="post">
    First Name: <input type="text" name="firstname"/><br/>
    Last Name: <input type="text" name="lastname"/><br/>
    <INPUT type="submit" value="Send">
</form>
</body>
</html>
