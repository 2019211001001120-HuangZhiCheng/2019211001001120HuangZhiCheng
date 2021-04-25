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

<%
    if(request.getAttribute("message")!=null){
        response.getWriter().write("<h3>"+request.getAttribute("message")+"</h3>");
    }
%>
<%
    Cookie[] allCookies = request.getCookies();
    String username="",password="",rememberMeVale="";
    if(allCookies!=null){
        for(Cookie c:allCookies){
            if(c.getName().equals("cUsername")){
                username = c.getValue();
            }
            if(c.getName().equals("cPassword")){
                password = c.getValue();
            }

            if(c.getName().equals("cRememberMe")){
                rememberMeVale = c.getValue();
            }

        }

    }

%>
<form action="login" method="post">
    UserName:<input type="text" name="username"value="<%=username%>"><br/>
    Password:<input type="text" name="password" value="<%=password%>"><br/>
    <input type="checkbox"name="rememberMe" value="1" <%=rememberMeVale.equals("1")?"checked":""%>checked/>Rememberme<br>
    <input type="submit" value="Login">
</form>



<br/>
<%@ include file="footer.jsp" %>

</body>
</html>
