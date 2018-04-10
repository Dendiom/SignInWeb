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
    <title>Title</title>
</head>
<body>

<p>username: <%= request.getAttribute("username")%></p>
<p>password: <%= request.getAttribute("password")%></p>

</body>
</html>
