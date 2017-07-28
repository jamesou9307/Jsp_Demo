<%--
  Created by IntelliJ IDEA.
  User: fsuser
  Date: 2017-07-17
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>employee</title>
</head>
<body>
accept-language:${header['accept-language']}
<br/>
session id:${pageContext.session.id}<br/>
employee:${requestScope.employee.name},<br/>
${requestScope.employee.address.city}<br/>
country:<br/>
${requestScope.country["China"]}<br/>
${requestScope.country["USA"]}<br/>
${requestScope.country["Japan"]}<br/>
<ul>
    <c:forEach items="${countries}" var="country">
        <li>${country.value}</li>
    </c:forEach>
</ul>
</body>
</html>
