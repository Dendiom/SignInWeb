package com.example.signinweb.bean;

import com.example.signinweb.enums.Code;

public class Result<T> {

    private Code code;
    private T obj;

    public Result(){}

    public Result(Code code, T obj) {
        this.code = code;
        this.obj = obj;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + obj.toString() + '\'' +
                '}';
    }
}
