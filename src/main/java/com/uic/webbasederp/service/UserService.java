package com.uic.webbasederp.service;

import com.uic.webbasederp.domain.po.User;
import com.uic.webbasederp.domain.vo.UserVo;

public interface UserService {
    void saveUser(User user);
    UserVo isRight(int employeeId, String password);
    void removeUser(int employeeId);
    void updateAuthority(int employeeId, int authority);
}
