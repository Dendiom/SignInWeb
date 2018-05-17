package com.example.signinweb.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 统计网站的总访问次数.
 */
public class CountFilter implements Filter {

    private final AtomicLong count = new AtomicLong(0);
    private Timer timer = new Timer();

    public void init(FilterConfig filterConfig) throws ServletException {
        // read from redis

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // write to redis
                System.out.println("count: " + count.longValue());
            }
        }, 10 * 1000, 30 * 60 * 1000);
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        count.incrementAndGet();
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
        timer.cancel();
    }
}
