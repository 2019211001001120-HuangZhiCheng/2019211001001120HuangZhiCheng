<%--
  Created by IntelliJ IDEA.
  User: Huang zhi cheng
  Date: 2021/4/9
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>User Info</h1>

<table><!--Use EL to do-->
    <tr><td>id:${user.id}</td></tr>
    <tr><td>username:${user.username}</td></tr>
    <tr><td>password:${user.password}</td></tr>
    <tr><td>email:${user.email}</td></tr>
    <tr><td>gender:${user.gender}</td></tr>
    <tr><td>birthdate:${user.birthDate}</td></tr>
</table>

</body>
</html>
<%@include file="footer.jsp"%>