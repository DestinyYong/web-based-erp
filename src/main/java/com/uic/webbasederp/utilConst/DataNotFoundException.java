package com.uic.webbasederp.utilConst;

public class DataNotFoundException extends BaseException {
    private static final String SEPARATOR = ": ";

    public DataNotFoundException() {
        super(ResponseCode.DATA_NOT_FOUND, ResponseMessage.DATA_NOT_FOUND);
    }

    public DataNotFoundException(String extraMessage) {
        super(ResponseCode.DATA_NOT_FOUND, ResponseMessage.DATA_NOT_FOUND + ": " + extraMessage);
    }
}
