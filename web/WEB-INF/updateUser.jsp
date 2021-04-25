<%--
  Created by IntelliJ IDEA.
  User: Huang zhi cheng
  Date: 2021/4/23
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="header.jsp"%>
<head>

</head>
<body>
<h1>User Update</h1>

<%
    User u = (User) session.getAttribute("user");
%>

<form method="post" action="updateUser">
    <input type="hidden" name="id"value="<%=u.getId()%>">
    Username:<input type="text" name="Username" placeholder="Username" value="<%=u.getUsername()%>"><br/>
    Password:<input type="text" name="Password" placeholder="Password" value="<%=u.getPassword()%>"><br/>
    Email:<input type="email" name="Email" placeholder="Email" value="<%=u.getEmail()%>"><br/>
    Gender:<input type="radio" name="gender" value="male"<%="male".equals(u.getGender())?"checked:":""%>>Male
    <input type="radio" name="gender"value="female"<%="female".equals(u.getGender())?"checked:":""%>>Female<br/>
    Date of birth:<input type="text" name="birthDate" value="<%=u.getBirthDate()%>"><br/>
    <input type="submit" value="Save Change" ><br/>
</form>

</body>
<%@include file="footer.jsp"%>
</html>
