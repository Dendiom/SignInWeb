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
</head>
<body bgcolor="yellow">
<div class="wrapper">
    <form class="form-signin" action="${pageContext.request.contextPath}/login" method="post">
        <h1 align="center">用户登录</h1>
        <input type="text" class="form-input" name="username" placeholder="用户名" required="" autofocus="" /><br/>
        <input class="form-input" type="password"  name="password" placeholder="密码" required=""/><br/>
        <label class="form-label">
            <input class="form-control" type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"> 记住账户密码
        </label><br/>
        <button class="form-button" type="submit">登录</button>
    </form>
</div>

</body>
</html>
