package com.uic.webbasederp.controller;

import com.uic.webbasederp.domain.po.User;
import com.uic.webbasederp.utilConst.CommonResultResponse;
import com.uic.webbasederp.utilConst.ResponseHelper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloWorldController {
    @RequestMapping("/hello")
    public ResponseEntity<CommonResultResponse> index() throws Exception{
        User user = new User();
        user.setPassword("123456");
        return ResponseHelper.success(user);
    }
}
