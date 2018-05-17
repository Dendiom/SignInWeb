package com.example.signinweb.servlet;

import javax.servlet.http.HttpServlet;
import java.net.Inet4Address;
import java.net.UnknownHostException;

public class BaseServlet extends HttpServlet{

    public static void main(String[] args) {
        try {
            System.out.println(Inet4Address.getByName("www.baidu.com").getHostAddress());
            System.out.println(Inet4Address.getByName("openbarrage.douyutv.com").getHostAddress());
            System.out.println(Inet4Address.getByName("www.douyutv.com").getHostAddress());
            System.out.println(Inet4Address.getByName("www.sina.com").getHostAddress());
            System.out.println(Inet4Address.getByName("www.ss.com").getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
