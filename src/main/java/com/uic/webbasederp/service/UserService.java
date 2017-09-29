package com.uic.webbasederp.service;

import com.uic.webbasederp.domain.po.User;

public interface UserService {
    void saveUser(User user);
    boolean isRight(int employeeId, String password);
    void removeUser(int employeeId);
    void updateAuthority(int employeeId);
}
