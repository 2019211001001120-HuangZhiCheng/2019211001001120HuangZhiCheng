<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2021
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>validate</title>
</head>
<body>
<c:choose>
    <c:when test="${param.username eq 'admin' and param.password eq 'admin'}">
            <%response.sendRedirect("welcome.jsp?username="+request.getParameter("username"));%>
    </c:when>
    <c:otherwise>
        <%request.setAttribute("message","Username Password Error");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        %>
    </c:otherwise>
</c:choose>
        <%--todo 3: when username == admin use c:url and c:param to make url = "welcome.jsp?username=admin"--%>

        <%-- todo 4.use c:redirect to url= welcome.jsp?username=admin--%>

    <%-- todo 5. use c:otherwise --%>

    <%-- todo 6:use c:set to set a attribute name message="username password error" in request  --%>

    <%--todo 7:use c:import to include login.jsp --%>

</body>
</html>
