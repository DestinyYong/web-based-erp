package com.uic.webbasederp.domain.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeVo {
    private int id;
    private String name;
    private String gender;
    private String department;
    private String position;
    private double salary;
    private String phoneNumber;
    private String address;
    private String IDCard;
    private int authority;
}
