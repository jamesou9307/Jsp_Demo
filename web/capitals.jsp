<%--
  Created by IntelliJ IDEA.
  User: fsuser
  Date: 2017-07-18
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Capitals</title>
    <style>
        table,tr,td{
            border: 1px solid #aaee77;
        }
    </style>
</head>
<body>
Capitals:
<table>
    <tr style="background: #448755;color: white;font-weight: bold">
        <td>Country</td>
        <td>Capital</td>
    </tr>
    <%--foreach标签对map对象的引用--%>
    <c:forEach items="${requestScope.capitals}" var="country">
        <tr>
            <td>${country.key}</td>
            <td>${country.value}</td>
        </tr>
    </c:forEach>
</table>
cities:
<table>
    <tr style="background: #449765;color: white;font-weight: bold">
        <td>Country</td>
        <td>Cities</td>
    </tr>
    <%--foreach标签对map对象的引用--%>
    <c:forEach items="${requestScope.cities}" var="mapItem">
    <tr>
        <td>${mapItem.key}</td>

        <td><c:forEach items="${mapItem.value}" var="valueItem" varStatus="status">
            ${valueItem}
            <c:if test="${!status.last}">,</c:if>
        </c:forEach></td>
    </tr>
    </c:forEach>

</body>
</html>
