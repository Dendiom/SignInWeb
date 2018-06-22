package com.example.signinweb.enums;

public enum  Code {
    /**
     * service success.
     */
    SUCCESS,

    /**
     * server error.
     */
    SERVER_ERROR,

    /**
     * mysql error.
     */
    MYSQL_ERROR,

    /**
     * login error.
     */
    USER_NOT_REGISTERED,
    PASSWORD_ERROR,

    /**
     * register error.
     */
    USER_HAS_ALREADY_REGISTERED,

    /**
     * sign in/out error.
     */
    HAVE_SIGN_IN,
    HAVE_SIGN_OUT,
    NOT_SIGN_IN

}
