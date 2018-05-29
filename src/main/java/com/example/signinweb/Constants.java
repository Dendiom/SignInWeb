package com.example.signinweb;

/**
 * 共享的常量类.
 */
public interface Constants {

    interface Cookies {
        String UID = "UID";
        String[] ALL_COOKIE = {UID};
    }

    interface SessionAttrs {
        String UID = "uid";
        String USER = "user";
    }

    interface ReqAttrs {
        String RESULT = "result";
        String USER = "user";
    }
}
