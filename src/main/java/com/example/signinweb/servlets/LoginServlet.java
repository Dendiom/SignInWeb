package com.example.signinweb.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet{

    private ServletContext servletContext;



    @Override
    public void init() throws ServletException {
        servletContext = getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        req.setAttribute("username", username);
        req.setAttribute("password", password);
        HttpSession session = req.getSession();
        session.setAttribute("username", username);

        Cookie cookie = new Cookie(servletContext.getInitParameter("COOKIE_SESSION_ID"), session.getId());
        cookie.setMaxAge(30 * 60);
        cookie.setPath("/");
        resp.addCookie(cookie);

        req.getRequestDispatcher("/main/form.jsp").forward(req, resp);
        //resp.sendRedirect("/form");
    }


}
