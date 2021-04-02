<%--
  Created by IntelliJ IDEA.
  User: Huang zhi cheng
  Date: 2021/3/12
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body >
<%@ include file="header.jsp" %>
This is my Register JSP page<br/>
<form method="post" action="../register">
    <input type="text" name="Username" placeholder="Username" required="required"><br/>
    <input type="text" name="Password" placeholder="Password" required="required" minlength="8"><br/>
    <input type="email" name="Email" placeholder="Email" required="required"><br/>
    Gender:<input type="radio" name="sex" checked>Male
    <input type="radio" name="sex" >Female<br/>
    <input type="text" name="birthday" placeholder="Date for birth(yyyy-mm-dd)" pattern="\d{4}-([0-2]|0[1-9]|1[0-2])-([1-9]|0[1-9]|1[0-9]|2[0-9]|3[0-1])" required="required"><br/>
    <input type="submit" value="Register" ><br/>
    <%@ include file="footer.jsp" %>
</form>
</body>
</html>
