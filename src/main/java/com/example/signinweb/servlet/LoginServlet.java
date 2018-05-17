package com.example.signinweb.servlet;

import com.example.signinweb.Constants;
import com.example.signinweb.util.Base64Util;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String rememberMe = req.getParameter("rememberMe");

        HttpSession session = req.getSession();
        session.setAttribute("username", username);

        //todo database ops
        Cookie cookie = new Cookie(Constants.Cookies.UID, Base64Util.encode("12"));
        cookie.setMaxAge(rememberMe == null ? -1 : 365 * 24 * 60 * 60);
        cookie.setPath("/");
        resp.addCookie(cookie);

        resp.sendRedirect("/main/form.jsp");
    }


}
