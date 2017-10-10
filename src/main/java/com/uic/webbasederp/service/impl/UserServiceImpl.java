package com.uic.webbasederp.service.impl;

import com.uic.webbasederp.domain.po.Employees;
import com.uic.webbasederp.domain.po.User;
import com.uic.webbasederp.domain.vo.UserVo;
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
    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    @Override
    public UserVo isRight(int employeeId, String password) {
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

    @Override
    public void removeUser(int employeeId) {

    }

    @Override
    public void updateAuthority(int employeeId, int authority) {
        userMapper.updateAuthority(employeeId, authority);
    }
}
