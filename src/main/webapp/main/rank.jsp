<%@ page import="com.example.signinweb.bean.User" %>
<%@ page import="com.example.signinweb.Constants" %><%--
  Created by IntelliJ IDEA.
  User: lucky
  Date: 2018/5/29
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
UserID: <%= ((User)session.getAttribute(Constants.SessionAttrs.USER)).getId()%>
Method: <%= request.getAttribute("time")%>
</body>
</html>
