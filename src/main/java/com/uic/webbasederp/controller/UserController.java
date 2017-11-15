package com.uic.webbasederp.controller;

import com.uic.webbasederp.domain.po.Employees;
import com.uic.webbasederp.domain.po.User;
import com.uic.webbasederp.domain.vo.LoginVo;
import com.uic.webbasederp.domain.vo.UserVo;
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
    @RequestMapping(value="/login",method = RequestMethod.POST,consumes="application/json",produces="application/json")
    public ResponseEntity<CommonResultResponse<Object>> login(@RequestBody LoginVo loginVo) throws Exception{
        CommonResultResponse<Object> responseBody = CommonResultResponse.buildSuccessCommonResultResponse(userService.isRight(loginVo.getEmployeeId(),loginVo.getPassword(),loginVo.getStatus()));
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
