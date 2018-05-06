<%--
  Created by IntelliJ IDEA.
  User: Lucky
  Date: 2018/4/10
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>签到页面</title>
</head>
<body>

<p>username: <%= request.getAttribute("username")%></p>
<p>password: <%= request.getAttribute("password")%></p>

<a href="form">点击跳转</a>

</body>
</html>
