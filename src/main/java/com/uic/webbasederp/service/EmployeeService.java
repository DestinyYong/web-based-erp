package com.uic.webbasederp.service;

import com.uic.webbasederp.domain.po.Employees;


import java.util.List;

public interface EmployeeService {
    int saveEmployee(Employees employees);
    List<Employees> getInformation(int page);
    void updateInformation(Employees employees);
    void removeEmplyee(int id);
    Employees getInformationById(int employeeId);
    List<Employees> getWorker();
}
