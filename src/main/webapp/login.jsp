<%--
  Created by IntelliJ IDEA.
  User: Pu Yuan
  Date: 2018/4/10
  Time: 18:54
  Login page.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="css/login.css">
    <script language="JavaScript" type="text/javascript" src="/js/inputCheck.js"></script>
</head>
<body bgcolor="#9acd32">
<div class="wrapper">
    <form class="form-signin" action="/login.do" method="post" onsubmit="return usernameCheck(document.getElementById('username').value)">
        <h1 align="center">用户登录</h1>
        <input class="form-input" type="text" name="username" id="username" placeholder="用户名" required="" autofocus="" /><br/>
        <input class="form-input" type="password" name="password" placeholder="密码" required=""/><br/>
        <label class="form-label">
            <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"> 记住账户密码
        </label><br/>
        <button class="form-button" type="submit">登录</button>
        <a class="form-label" href="/register.jsp">还没有用户，点击此处注册</a>
    </form>
</div>

</body>
</html>
