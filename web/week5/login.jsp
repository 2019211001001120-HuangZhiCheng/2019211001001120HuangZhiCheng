<%--
  Created by IntelliJ IDEA.
  User: Huang zhi cheng
  Date: 2021/4/2
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%@ include file="header.jsp" %>
<br/>
<h1>Login</h1>

<form action="login" method="post">
    UserName:<input type="text" name="username"><br/>
    Password:<input type="text" name="password"><br/>
    <input type="submit" value="Login">
</form>



<br/>
<%@ include file="footer.jsp" %>

</body>
</html>
