package com.example.signinweb.servlet;

import com.example.signinweb.Constants;
import com.example.signinweb.bean.Result;
import com.example.signinweb.bean.User;
import com.example.signinweb.enums.Code;
import com.example.signinweb.service.UserService;
import com.example.signinweb.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class PerfectInfoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute(Constants.SessionAttrs.UID);
        User userBean = new User();
        if (userId == null) {
            request.setAttribute(Constants.ReqAttrs.ERROR, new Result<>(Code.SERVER_ERROR, "服务器错误"));
            request.getRequestDispatcher("/perfectInfo.jsp").forward(request, response);
            return;
        }

        userBean.setId(userId);
        userBean.setNickname(request.getParameter("nickname"));
        userBean.setSex(Integer.valueOf(request.getParameter("sex")));
        userBean.setGrade(request.getParameter("grade"));
        userBean.setPhone(request.getParameter("phone"));
        userBean.setMail(request.getParameter("mail"));
        userBean.setDescription(request.getParameter("description"));
        Result result = userService.perfectInfo(userBean);

        if (Code.SUCCESS == result.getCode()) {
            response.sendRedirect("/login.jsp");
            return;
        }

        request.setAttribute(Constants.ReqAttrs.ERROR, result);
        request.getRequestDispatcher("/perfectInfo.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
