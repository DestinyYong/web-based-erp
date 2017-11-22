package com.uic.webbasederp.service.impl;

import com.uic.webbasederp.domain.po.Employees;
import com.uic.webbasederp.domain.vo.EmployeeVo;
import com.uic.webbasederp.mapper.EmployeeMapper;
import com.uic.webbasederp.mapper.UserMapper;
import com.uic.webbasederp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private UserMapper userMapper;

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
    public List<EmployeeVo> getInformation() {
        List<Employees> employees = employeeMapper.getInformation();
        List<EmployeeVo> employeeVos = new ArrayList<>();
        for(Employees employee : employees){
            EmployeeVo employeeVo = new EmployeeVo();
            employeeVo.setAddress(employee.getAddress());
            employeeVo.setDepartment(employee.getDepartment());
            employeeVo.setGender(employee.getGender());
            employeeVo.setId(employee.getId());
            employeeVo.setIDCard(employee.getIDCard());
            employeeVo.setName(employee.getName());
            employeeVo.setPhoneNumber(employee.getPhoneNumber());
            employeeVo.setPosition(employee.getPosition());
            employeeVo.setSalary(employee.getSalary());
            employeeVo.setAuthority(userMapper.getAuthority(employee.getId()));
        }

        return null;
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
        return employeeMapper.getInformationById(employeeId);
    }

    @Override
    public List<Employees> getWorker() {
        return employeeMapper.getWorker();
    }
}
