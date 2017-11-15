package com.uic.webbasederp.controller;

import com.uic.webbasederp.domain.po.Customer;
import com.uic.webbasederp.domain.po.Employees;
import com.uic.webbasederp.domain.po.User;
import com.uic.webbasederp.service.CustomerService;
import com.uic.webbasederp.service.UserService;
import com.uic.webbasederp.utilConst.CommonResultResponse;
import com.uic.webbasederp.utilConst.ResponseHelper;
import com.uic.webbasederp.utilConst.ResponseMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserService userService;

    @ApiOperation(value = "add a new customer")
    @RequestMapping(value="/new",method = RequestMethod.POST)
    public ResponseEntity<CommonResultResponse> saveCustomer(@RequestBody Customer customer) throws Exception{
        customerService.saveCustomer(customer);
        User user = new User();
        user.setEmployeeId(customer.getCustomerId());
        user.setAuthority(1);
        userService.saveUser(user);
        return ResponseHelper.success();
    }

    @ApiOperation(value = "add a new customer")
    @RequestMapping(value="/all",method = RequestMethod.GET)
    public ResponseEntity<CommonResultResponse<List<Customer>>> getCustomer() throws Exception{
        CommonResultResponse<List<Customer>> responseBody = CommonResultResponse.buildSuccessCommonResultResponse(customerService.getCustomer());
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
