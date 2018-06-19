package com.example.signinweb.servlet;

import com.example.signinweb.Constants;
import com.example.signinweb.bean.Result;
import com.example.signinweb.bean.User;
import com.example.signinweb.enums.Code;
import com.example.signinweb.service.UserService;
import com.example.signinweb.service.impl.UserServiceImpl;
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

        UserService userService = new UserServiceImpl();
        Result result = userService.login(username, password);

        // 成功登陆
        if (result.getCode() == Code.SUCCESS) {
            User user = (User)result.getObj();
            Cookie cookie = new Cookie(Constants.Cookies.UID, Base64Util.encode(String.valueOf(user.getId())));
            cookie.setMaxAge(rememberMe == null ? -1 : 365 * 24 * 60 * 60);
            cookie.setPath("/");
            resp.addCookie(cookie);

            HttpSession session = req.getSession();
            session.setAttribute(Constants.SessionAttrs.USER, result.getObj());

            resp.sendRedirect("/main/form.jsp");
            return;
        }

        req.setAttribute(Constants.ReqAttrs.ERROR, result);
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }
}
