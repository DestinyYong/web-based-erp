package com.uic.webbasederp.mapper;

import com.uic.webbasederp.domain.po.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void saveUser(User user);
    Integer isRight(int employeeId, String password);
    void removeUser(int employeeId);
    void updateAuthority(int employeeId, int authority);
}
