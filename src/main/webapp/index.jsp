<%@ page import="com.example.signinweb.util.CookieUtil" %>
<%@ page import="com.example.signinweb.Constants" %><%--
  Created by IntelliJ IDEA.
  User: Lucky
  Date: 2018/3/7
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>签到系统</title>
</head>
<body>

<%--<jsp:forward page="/jsp/login.jsp" />--%>
<%
    //request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
    String login = CookieUtil.getCookieValue(Constants.Cookies.UID, request);
    if (login == null) {
        response.sendRedirect("/login.jsp");
    } else {
        response.sendRedirect("/main/form.jsp");
    }
%>

</body>

</html>
