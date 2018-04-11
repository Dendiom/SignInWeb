package com.example.signinweb.filters;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class SessionFilter implements javax.servlet.Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
