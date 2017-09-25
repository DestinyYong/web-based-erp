package com.uic.webbasederp.utilConst;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.beans.ConstructorProperties;
import java.io.Serializable;

@JsonPropertyOrder({"code", "message"})
public class CommonResponse implements Serializable {
    private static final long serialVersionUID = -2564445585181441109L;
    private int code;
    private String message;
    private static final transient CommonResponse successResponse;

    public static CommonResponse buildSuccessCommonResponse() {
        return successResponse;
    }

    public CommonResponse() {
    }

    @ConstructorProperties({"code", "message"})
    public CommonResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    static {
        successResponse = new CommonResponse(ResponseCode.SUCCESS, "");
    }
}
