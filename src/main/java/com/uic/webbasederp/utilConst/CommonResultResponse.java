package com.uic.webbasederp.utilConst;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.beans.ConstructorProperties;
import java.io.Serializable;

@JsonPropertyOrder({"code", "message", "result"})
public class CommonResultResponse<T> extends CommonResponse implements Serializable {
    private static final long serialVersionUID = 2523377728598055414L;
    private T result;

    public static <T> CommonResultResponse<T> buildSuccessCommonResultResponse(T result) {
        CommonResultResponse<T> response = new CommonResultResponse();
        response.setCode(ResponseCode.SUCCESS);
        response.setResult(result);
        return response;
    }

    public CommonResultResponse() {
    }

    @ConstructorProperties({"result"})
    public CommonResultResponse(T result) {
        this.result = result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public T getResult() {
        return this.result;
    }
}
