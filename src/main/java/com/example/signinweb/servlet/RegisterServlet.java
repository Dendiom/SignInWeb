package com.example.signinweb.servlet;

import com.example.signinweb.Constants;
import com.example.signinweb.bean.Result;
import com.example.signinweb.enums.Code;
import com.example.signinweb.service.UserService;
import com.example.signinweb.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Result result = userService.register(username, password);
        HttpSession session = req.getSession();
        if (result.getCode() == Code.SUCCESS) {   // 成功注册
            session.setAttribute(Constants.SessionAttrs.UID, result.getObj());
            resp.sendRedirect("perfectInfo.jsp");
        } else {
            req.setAttribute(Constants.ReqAttrs.ERROR, result);
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
    }
}
