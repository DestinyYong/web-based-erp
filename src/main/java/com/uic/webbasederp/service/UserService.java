package com.uic.webbasederp.service;

public interface UserService {
    int saveUser();
    boolean isRight(int eId, String password);
    void removeUser(int eId);
}
