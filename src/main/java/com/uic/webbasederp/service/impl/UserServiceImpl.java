package com.uic.webbasederp.service.impl;

import com.uic.webbasederp.domain.po.Customer;
import com.uic.webbasederp.domain.po.Employees;
import com.uic.webbasederp.domain.po.User;
import com.uic.webbasederp.domain.vo.CustomerVo;
import com.uic.webbasederp.domain.vo.UserVo;
import com.uic.webbasederp.mapper.CustomerMapper;
import com.uic.webbasederp.mapper.EmployeeMapper;
import com.uic.webbasederp.mapper.UserMapper;
import com.uic.webbasederp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    @Override
    public Object isRight(int employeeId, String password, Integer status) {

        if(status == 1){
            UserVo userVo = new UserVo();
            if(userMapper.isRight(employeeId,password) != null){
                Employees employee = employeeMapper.getInformationById(employeeId);
                userVo.setName(employee.getName());
                userVo.setEmployeeId(employee.getId());
                userVo.setDepartment(employee.getDepartment());
                userVo.setPosition(employee.getPosition());
                userVo.setAuthority(userMapper.isRight(employeeId,password));
                return userVo;
            }
            else{
                userVo.setAuthority(-1);
                return userVo;
            }
        }
        else{
            CustomerVo customerVo = new CustomerVo();
            if(userMapper.isRight(employeeId,password) != null){
                Customer customer = customerMapper.getCustomerById(employeeId);
                customerVo.setCustomerId(customer.getCustomerId());
                customerVo.setCompany(customer.getCompany());
                customerVo.setAuthority(userMapper.isRight(employeeId, password));
                return customerVo;
            }
            else{
                customerVo.setAuthority(-1);
                return customerVo;
            }
        }
    }

    @Override
    public void removeUser(int employeeId) {

    }

    @Override
    public void updateAuthority(int employeeId, int authority) {
        userMapper.updateAuthority(employeeId, authority);
    }
}
