package com.uic.webbasederp.service;

import com.uic.webbasederp.domain.po.Employee;

public interface EmployeeService {
    Employee getInfomation(int eId);
    void saveInfomation(int eId);
}
