package com.uic.webbasederp.service.impl;

import com.uic.webbasederp.domain.po.Employees;
import com.uic.webbasederp.mapper.EmployeeMapper;
import com.uic.webbasederp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * save a new employee in database
     * @return employee id
     */
    @Override
    public int saveEmployee(Employees employees) {

        employeeMapper.saveEmployee(employees);
        return employees.getId();

    }

    /**
     * get a employee information

     * @return Employees
     */
    @Override
    public List<Employees> getInformation(int page) {
        List<Employees> employees = employeeMapper.getInformation((page-1)*15);

        return employees;
    }

    /**
     * update the information of employee
     */
    @Override
    public void updateInformation(Employees employees) {
        employeeMapper.updateInformation(employees);

    }

    /**
     * delete employee from database
     * @param id
     */
    @Override
    public void removeEmplyee(int id) {

    }

    @Override
    public Employees getInformationById(int employeeId) {
        return null;
    }
}
