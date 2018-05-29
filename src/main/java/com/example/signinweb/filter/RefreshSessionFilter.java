package com.example.signinweb.filter;

import com.example.signinweb.Constants;
import com.example.signinweb.bean.Result;
import com.example.signinweb.enums.Code;
import com.example.signinweb.service.UserService;
import com.example.signinweb.service.impl.UserServiceImpl;
import com.example.signinweb.util.Base64Util;
import com.example.signinweb.util.CookieUtil;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RefreshSessionFilter implements Filter {

    private static Logger logger = Logger.getLogger(RefreshSessionFilter.class);

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpSession session = ((HttpServletRequest)req).getSession();
        if (session.getAttribute(Constants.SessionAttrs.USER) == null) {
            //refresh
            UserService userService = new UserServiceImpl();
            String uid = CookieUtil.getCookieValue(Constants.Cookies.UID, req);
            System.out.println("uid" + uid);
            String decode = Base64Util.decode(uid);
            System.out.println("uid2" + decode);
            long id = Long.valueOf(Base64Util.decode(CookieUtil.getCookieValue(Constants.Cookies.UID, req)));
            Result result = userService.getUserInfo(id);
            if (result.getCode() == Code.SUCCESS) {
                logger.info("refresh session info userId = " + id);
                session.setAttribute(Constants.SessionAttrs.USER, result.getObj());
            } else {
                logger.error(result.getObj());
            }
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }
}
