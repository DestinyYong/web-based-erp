package com.uic.webbasederp.mapper;

import com.uic.webbasederp.domain.po.Employees;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    void saveEmployee(Employees employees);
    List<Employees> getInformation();
    void updateInformation(Employees employees);
    void removeEmplyee(int id);
    Employees getInformationById(int employeeId);
    List<Employees> getWorker();
}
