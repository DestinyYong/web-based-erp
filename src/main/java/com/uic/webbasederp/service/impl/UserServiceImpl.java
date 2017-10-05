package com.uic.webbasederp.service.impl;

import com.uic.webbasederp.domain.po.User;
import com.uic.webbasederp.mapper.UserMapper;
import com.uic.webbasederp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    @Override
    public Integer isRight(int employeeId, String password) {
        if(userMapper.isRight(employeeId,password) != null){
            return userMapper.isRight(employeeId,password);
        }
        else{
            return -1;
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
