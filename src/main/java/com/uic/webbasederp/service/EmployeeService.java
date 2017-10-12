package com.uic.webbasederp.service;

import com.uic.webbasederp.domain.po.Employees;


import java.util.List;

public interface EmployeeService {
    int saveEmployee(Employees employees);
    List<Employees> getInfomation(int page);
    void updateInfomation(Employees employees);
    void removeEmplyee(int id);
}
