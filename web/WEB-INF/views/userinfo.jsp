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
    <tr><td>id:${sessionScope.user.id}</td></tr>
    <tr><td>username:${sessionScope.user.username}</td></tr>
    <tr><td>password:${sessionScope.user.password}</td></tr>
    <tr><td>email:${sessionScope.user.email}</td></tr>
    <tr><td>gender:${sessionScope.user.gender}</td></tr>
    <tr><td>birthdate:${sessionScope.user.birthDate}</td></tr>
</table>
<a href="<%request.getRequestDispatcher("/WEB-INF/views/updateUser.jsp").forward(request,response);%>">update</a>
<!--前端界面不能直接访问web-inf下的文件只能通过后台转发请求访问-->

</body>
</html>
<%@include file="footer.jsp"%>