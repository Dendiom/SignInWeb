package com.example.signinweb;

/**
 * 共享的常量类.
 */
public interface Constants {

    interface Cookies {
        String UID = "UID";
        String[] ALL_COOKIE = {UID};  // 方便登出时清空cookie
    }

    interface SessionAttrs {
        String UID = "uid";
        String USER = "user";
        String RECORD = "record";
        String TOTAL_TIME = "total_time";
    }

    interface ReqAttrs {
        String ERROR = "error";
        String USER = "user";
        String RANK = "rank";
    }

    interface AppAttris {
        String WEEK = "week";
    }
}
