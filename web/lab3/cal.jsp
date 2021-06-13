<%--
  Created by IntelliJ IDEA.
  User: Huang zhi cheng
  Date: 2021/6/13
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="CalServlet">
    First val:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="firstVal">&nbsp;Enter a Name:<input type="text" name="name"><br/>
    Second val:<input type="text" name="secondVal">&nbsp;
        Length:<% Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
//            名字匹配上了就输出，其他的同理
            if("lengthError".equals(cookie.getName()))out.print(cookie.getValue());
            else if("length".equals(cookie.getName()))out.print(cookie.getValue());
        }
    %><br/>
    Result:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%
        for(Cookie cookie:cookies){
//            名字匹配上了就输出，其他的同理
            if("error".equals(cookie.getName()))out.print(cookie.getValue());
            else if("value".equals(cookie.getName()))out.print(cookie.getValue());
        }
    %><br/>
    <input type="submit" value="Add" name="Add">&nbsp;<input type="submit" value="Subtract" name="Subtract">
        &nbsp;<input type="submit" value="Multiply" name="Multiply">&nbsp;<input type="submit" value="divide" name="divide">&nbsp;
    <input type="submit" value="ComputeLength" name="ComputeLength">&nbsp;<input type="submit" value="Reset" name="Reset">
    </form>


</body>
</html>
