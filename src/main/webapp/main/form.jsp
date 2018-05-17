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
    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
        }

        html, body {
            height: 100%;
            width: 100%;
        }
    </style>
</head>
<body>
<div class="banner" style="background-color: white;width:100%;height: 10%">
    <div class="info" style="text-align: right;margin-top: 5px;margin-right: 8px;font-size: 15px">
        欢迎你：<%= session.getAttribute("username") %>
        <a href="/logout.do">  退出登录</a>
    </div>
    <div class="title" style="text-align: center;font-size: 20px">
        <p>欢迎使用此签到系统</p>
    </div>
    <a target="main" href="../login.jsp">baidu</a>
    <a target="main" href="../register.jsp">taobao</a>
</div>
<div style="height: 2px;width: 100%;background-color: black"></div>
<iframe name="main" style="background-color: white;width: 100%;height: 90%;"></iframe>

</body>

</html>
