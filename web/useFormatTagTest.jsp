<%--
  Created by IntelliJ IDEA.
  User: fsuser
  Date: 2017-07-20
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>useFormatTag</title>
</head>
<body>
<jsp:useBean id="now" class="java.util.Date"/>
default:<fmt:formatDate value="${now}" /><br/>
Short:<fmt:formatDate value="${now}" dateStyle="short"/><br/>
Medium:<fmt:formatDate value="${now}" dateStyle="medium"/><br/>
Long:<fmt:formatDate value="${now}" dateStyle="long"/><br/>
Full:<fmt:formatDate value="${now}" dateStyle="full"/><br/>

rmb:<fmt:formatNumber value="12" type="currency" currencyCode="CNY"/><br/>
jpy:<fmt:formatNumber value="12" type="currency" currencyCode="JPY"/><br/>
usd:<fmt:formatNumber value="12" type="currency" currencyCode="USD"/><br/>



</body>
</html>
