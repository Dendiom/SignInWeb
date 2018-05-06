<%--
  Created by IntelliJ IDEA.
  User: Pu Yuan
  Date: 2018/4/10
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="css/register.css">
</head>
<body bgcolor="#9acd32">
<div class="wrapper">
    <form class="form-signin" action="/register.do" method="post">
        <h1 align="center">用户注册</h1>
        <input class="form-input" type="text" name="username" placeholder="请输入6~15位用户名" required="" autofocus="" /><br/>
        <input class="form-input" type="password" name="password" placeholder="请输入密码" required=""/><br/>
        <input class="form-input" type="password" name="password_again" placeholder="请再次输入密码" required=""/><br/>
        <button class="form-button" type="submit">注册</button>
    </form>
</div>

</body>
</html>
