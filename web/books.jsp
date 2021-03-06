<%--
  Created by IntelliJ IDEA.
  User: fsuser
  Date: 2017-07-18
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Book List</title>
    <style>
        table,tr,td{
            border: 1px solid brown;

        }
    </style>
</head>
<body>
Book in Simple Table
<table>
    <tr>
        <td>ISBN</td>
        <td>Title</td>
    </tr>
    <c:forEach items="${requestScope.books}" var="book">
        <tr>
            <td>${book.isbn}</td>
            <td>${book.bookname}</td>
        </tr>
    </c:forEach>
</table>
Book in Styled Table
<table>
    <tr style="background: #ababff">
        <td>ISBN</td>
        <td>Title</td>
    </tr>
    <c:forEach items="${requestScope.books}" var="book" varStatus="status">
        <c:if test="${status.count%2==0}">
            <tr style="background: #eeeeff">
        </c:if>
        <c:if test="${status.count%2!=0}">
            <tr style="background: #dedeff">
        </c:if>
            <td>${book.isbn}</td>
            <td>${book.bookname}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
