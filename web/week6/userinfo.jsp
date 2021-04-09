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
    <tr><td>id:${id}</td></tr>
    <tr><td>username:${username}</td></tr>
    <tr><td>password:${password}</td></tr>
    <tr><td>email:${email}</td></tr>
    <tr><td>gender:${gender}</td></tr>
    <tr><td>birthdate:${birthdate}</td></tr>
</table>

</body>
</html>
<%@include file="footer.jsp"%>