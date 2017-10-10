package com.uic.webbasederp.domain.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVo {
    private Integer employeeId;
    private String name;
    private String department;
    private String position;
    private Integer authority;
}
