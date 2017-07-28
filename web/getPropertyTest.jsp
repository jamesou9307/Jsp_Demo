<%--
  Created by IntelliJ IDEA.
  User: fsuser
  Date: 2017-07-17
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>getPropertyTest</title>
</head>
<body>
<jsp:useBean id="employee" class="com.james.jspdemo.entity.Employee"/>
<jsp:setProperty name="employee" property="name" value="james"/>
<jsp:setProperty name="employee" property="id" value="4125"/>
<jsp:getProperty name="employee" property="id"/>
<jsp:getProperty name="employee" property="name"/>
</body>
</html>
