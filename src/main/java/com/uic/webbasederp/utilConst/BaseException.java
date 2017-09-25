package com.uic.webbasederp.utilConst;

import java.beans.ConstructorProperties;

public abstract class BaseException extends Exception {
    private static final long serialVersionUID = -700782141122462621L;
    private int code;
    private String message;

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @ConstructorProperties({"code", "message"})
    public BaseException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseException() {
    }
}
