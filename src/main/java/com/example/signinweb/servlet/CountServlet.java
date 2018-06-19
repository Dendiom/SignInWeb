package com.example.signinweb.servlet;

import com.example.signinweb.Constants;
import com.example.signinweb.bean.Result;
import com.example.signinweb.bean.User;
import com.example.signinweb.service.RecordService;
import com.example.signinweb.service.impl.RecordServiceImpl;
import com.example.signinweb.util.TimeUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CountServlet extends HttpServlet {

    private static final String GET = "get";
    private static final String SIGN_IN = "sign_in";
    private static final String SIGN_OUT = "sign_out";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute(Constants.SessionAttrs.USER);

        if (method == null || GET.equals(method)) {
            getRecord(req, user, session);
        } else if (SIGN_IN.equals(method)) {

        } else if (SIGN_OUT.equals(method)) {

        }

        req.getRequestDispatcher("/main/count.jsp").forward(req, resp);
    }

    /**
     * 获取本周签到数据.
     */
    private void getRecord(HttpServletRequest req, User user, HttpSession session) {
        RecordService recordService = new RecordServiceImpl();
        Result result = recordService.getWeekRecords(user.getUsername(), TimeUtil.getWeekIdentifier());
        req.setAttribute(Constants.ReqAttrs.ERROR, result.getObj());
    }
}
