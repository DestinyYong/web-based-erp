package com.uic.webbasederp.controller;

import com.uic.webbasederp.domain.po.Employees;
import com.uic.webbasederp.domain.po.User;
import com.uic.webbasederp.service.UserService;
import com.uic.webbasederp.utilConst.CommonResultResponse;
import com.uic.webbasederp.utilConst.ResponseHelper;
import com.uic.webbasederp.utilConst.ResponseMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "login and check user authority")
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public ResponseEntity<CommonResultResponse<Integer>> login(@RequestParam int employeeId, @RequestParam String password) throws Exception{
        CommonResultResponse<Integer> responseBody = CommonResultResponse.buildSuccessCommonResultResponse(userService.isRight(employeeId,password));
        responseBody.setMessage(ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    @ApiOperation(value = "change authority")
    @RequestMapping(value="/authority",method = RequestMethod.POST)
    public ResponseEntity<CommonResultResponse> changeAuthority(@RequestParam int employeeId, @RequestParam int authority) throws Exception{
        userService.updateAuthority(employeeId, authority);
        return ResponseHelper.success();
    }
}
