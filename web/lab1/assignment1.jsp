<%@ page import="com.lab1.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lab1.Dog" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2021
  Time: 9:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Assignemnt1</title>
</head>
<body>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<h1> c:forEach loog to print 1 to 10</h1>

    <ul>
        <c:forEach var="i" begin="1" end="10">
        <li>${i}</li>
        </c:forEach>
    </ul>
<h1> c:forEach to print list 1,3,5,7,9</h1>
    <ul>
        <c:forEach var="i" begin="1" end="10">
            <c:if test="${i%2!=0}">
                <li>${i}</li>
            </c:if>
        </c:forEach>
    </ul>
<h1> c:forEach to print 2,4,6,8,10</h1>
<ul>
    <c:forEach var="i" begin="1" end="10">
        <c:if test="${i%2==0}">
            <li>${i}</li>
        </c:if>
    </c:forEach>
</ul>
    <%-- todo 1 : run assignement1.jsp  --%>
    <%-- todo 2 : use c:forEach to print list 1,3,5,7,9   --%>
   <%-- todo 3 : use use c:forEach to print 2,4,6,8,10   --%>

<% String[] words ={"one","two","three","four","five","six","seven","eight","nine","ten"};
   pageContext.setAttribute("words", words);
%>
<h1>c:forEach to print all elements of array</h1>
<ul>
    <c:forEach var="word" items="${words}">
            <li>${word}</li>
    </c:forEach>
</ul>
    <%-- todo 4 : use c:forEach to print all elements of array --%>

<h1>c:forEach to print "one","three","five","seven","nine"  of array</h1>
<ul>
    <c:forEach var="word" items="${words}" varStatus="st">
        <c:if test="${st.count%2!=0}">
            <li>${word}</li>
        </c:if>
    </c:forEach>
</ul>

    <%-- todo 5 : use c:forEach to print "one","three","five","seven","nine"  of array --%>
<%
List<Person> personList=new ArrayList<Person>();
personList.add(new Person("Tom",new Dog("Tommy")));
personList.add(new Person("Sam",new Dog("Sammy")));
personList.add(new Person("Jack",new Dog("Summer")));
// todo 6 : add a new person into PersonList - person name and dog name
request.setAttribute("AllPerson",personList);
%>
<h1>c:forEach to print person name :   and persons' dog name</h1>
<ul>
    <c:forEach var="person" items="${AllPerson}">
        <li>${person.name}: ${person.dog.name}</li>
    </c:forEach>
</ul>

<%--//todo 7: use c:forEach to print person name :   and persons' dog name : --%>
<%
    String str="one:two:three-four-five";
%>
<h1>c:forToken to print all words</h1>
<c:forTokens items="<%=str%>" delims="-:" varStatus="st">

        <c:if test="${st.current!='o'}">
            ${st.current}
        </c:if>

</c:forTokens>
<%--todo 8 : use c:forToken to print all words --%>
</body>
</html>
