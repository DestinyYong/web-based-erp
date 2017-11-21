package com.uic.webbasederp.controller;

import com.uic.webbasederp.domain.po.Employees;
import com.uic.webbasederp.domain.po.User;
import com.uic.webbasederp.service.EmployeeService;
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

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserService userService;
    @ApiOperation(value = "add a employee")
    @RequestMapping(value="/new",method = RequestMethod.POST)
    public ResponseEntity<CommonResultResponse<Integer>> saveEmployee(@RequestBody Employees employees) throws Exception{
        Integer employeeId = employeeService.saveEmployee(employees);

        User user = new User();
        user.setEmployeeId(employeeId);
        userService.saveUser(user);
        CommonResultResponse<Integer> responseBody = CommonResultResponse.buildSuccessCommonResultResponse(employeeId);
        responseBody.setMessage(ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    @ApiOperation(value = "list 15 employees")
    @RequestMapping(value="/show",method = RequestMethod.GET)
    public ResponseEntity<CommonResultResponse<List<Employees>>> listEmployee(@RequestParam Integer page) throws Exception{
        List<Employees> employees = employeeService.getInformation(page);
        CommonResultResponse<List<Employees>> responseBody = CommonResultResponse.buildSuccessCommonResultResponse(employees);
        responseBody.setMessage(ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    @ApiOperation(value = "update one employee")
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public ResponseEntity<CommonResultResponse> updateEmployee(@RequestBody Employees employees) throws Exception{
        employeeService.updateInformation(employees);
        return ResponseHelper.success();
    }

    @ApiOperation(value = "get all the worker")
    @RequestMapping(value="/worker",method = RequestMethod.GET)
    public ResponseEntity<CommonResultResponse<List<Employees>>> updateEmployee() throws Exception{
        CommonResultResponse<List<Employees>> responseBody = CommonResultResponse.buildSuccessCommonResultResponse(employeeService.getWorker());
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
