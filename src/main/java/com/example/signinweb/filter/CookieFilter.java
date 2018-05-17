package com.example.signinweb.filter;

import com.example.signinweb.Constants;
import com.example.signinweb.util.Base64Util;
import com.example.signinweb.util.CookieUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 此过滤器检查用户的登录是否过期，过期则跳转到登录界面.
 */
public class CookieFilter implements javax.servlet.Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String cookie = CookieUtil.getCookieValue(Constants.Cookies.UID, servletRequest);
        boolean legal = Base64Util.check(cookie);
        if (legal) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            ((HttpServletResponse)servletResponse).sendRedirect("/login.jsp");
        }
    }

    public void destroy() {

    }
}
