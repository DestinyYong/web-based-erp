package com.uic.webbasederp.utilConst;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHelper {
    public ResponseHelper() {
    }

    public static <T> ResponseEntity<CommonResultResponse> success(T result) throws Exception {
        return success(result, false);
    }

    public static ResponseEntity<CommonResultResponse> success() throws Exception {
        return success("", false);
    }

    public static <T> ResponseEntity<CommonResultResponse> success(T result, boolean emptyCheck) throws Exception {
        if (emptyCheck && EmptyValidator.isEmpty(result)) {
            throw new DataNotFoundException();
        } else {
            CommonResultResponse response = new CommonResultResponse();
            response.setCode(ResponseCode.SUCCESS);
            response.setMessage(ResponseMessage.SUCCESS);
            response.setResult(result);
            return new ResponseEntity(response, HttpStatus.OK);
        }
    }
}
