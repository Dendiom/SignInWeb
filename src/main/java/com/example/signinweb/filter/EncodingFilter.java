package com.example.signinweb.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EncodingFilter implements Filter {

    private String encode = null;

    public void init(FilterConfig config) throws ServletException {
        encode = config.getInitParameter("encode");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding(encode);
        resp.setCharacterEncoding(encode);
        chain.doFilter(req, resp);
    }

    public void destroy() {}
}
