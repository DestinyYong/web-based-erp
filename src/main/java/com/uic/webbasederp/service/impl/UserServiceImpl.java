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
    public boolean isRight(int employeeId, String password) {
        return false;
    }

    @Override
    public void removeUser(int employeeId) {

    }

    @Override
    public void updateAuthority(int employeeId) {

    }
}
