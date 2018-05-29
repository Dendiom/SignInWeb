package com.example.signinweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;

public class CountServlet extends HttpServlet {

    private static final String GET = "get";
    private static final String SIGN_IN = "sign_in";
    private static final String SIGN_OUT = "sign_out";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");

        if (GET.equals(method)) {
            getRecord(req, resp);
        } else if (SIGN_IN.equals(method)) {

        } else if (SIGN_OUT.equals(method)) {

        }

        req.getRequestDispatcher("/main/count.jsp").forward(req, resp);
    }

    private void getRecord(HttpServletRequest req, HttpServletResponse resp) {
        long now = System.currentTimeMillis() / 1000;


    }
}
