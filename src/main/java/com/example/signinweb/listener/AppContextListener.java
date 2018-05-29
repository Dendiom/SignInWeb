package com.example.signinweb.listener;

import com.example.signinweb.lib.mysql.C3p0Helper;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppContextListener implements ServletContextListener {

    private static Logger logger = Logger.getLogger(AppContextListener.class);

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("server start");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        // 关闭数据库连接
        logger.info("server exit");
        C3p0Helper.close();
    }
}
