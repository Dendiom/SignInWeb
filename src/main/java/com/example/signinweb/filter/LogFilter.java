package com.example.signinweb.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LogFilter implements Filter {

    private static Logger logger = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        logger = Logger.getLogger(LogFilter.class);
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("client address: " + servletRequest.getRemoteAddr() +
                "   url: " + ((HttpServletRequest) servletRequest).getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
