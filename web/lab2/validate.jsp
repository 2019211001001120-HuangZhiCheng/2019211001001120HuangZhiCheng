<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2021
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>validate</title>
</head>
<body>
<%--Todo 1: Use <jsp:useBean> to create a Login bean instance in request scope --%>
<jsp:useBean id="login" class="com.hzc.lab2.Login" scope="request"/>

    <%--Todo 2: Use <jsp:setProperty> to set  beans' property username and password--%>
<jsp:setProperty name="login" property="*"/>
<%
   //todo 3: use if check username is admin and ppassword is admin
%>

<c:choose>
    <c:when test="${login.username eq 'admin' and login.password eq 'admin'}">
        <jsp:forward page="welcome.jsp"/>
    </c:when>
    <c:when test="${login.username ne 'admin' or login.password ne 'admin'}">
        <h1>username or password error</h1>
        <jsp:include page="login.jsp"/>
    </c:when>
</c:choose>


    <%--todo 5: else part{ --%>

<%
// todo 6: print username or password error message

%>
    <%--todo 7: use jsp:include login.jsp page --%>

    <%--todo 8: close else --%>

</body>
</html>