package com.example.signinweb.servlet;

import com.example.signinweb.Constants;
import com.example.signinweb.bean.Result;
import com.example.signinweb.enums.Code;
import com.example.signinweb.service.RankService;
import com.example.signinweb.service.impl.RankServiceImpl;
import com.example.signinweb.util.TimeUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RankServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RankService rankService = new RankServiceImpl();
        Result result = rankService.getRank(TimeUtil.getWeekIdentifier());
        if (result.getCode() == Code.SUCCESS) {
            req.setAttribute(Constants.ReqAttrs.RANK, result.getObj());
            req.getRequestDispatcher("rank.jsp").forward(req, resp);
            return;
        }

        req.setAttribute(Constants.ReqAttrs.ERROR, result);
        req.getRequestDispatcher("rank.jsp").forward(req, resp);
    }
}
