package com.uic.webbasederp.domain.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InspectionVo {
    private int productId;
    private String productName;
    private String defectName;
    private String defectDescription;
    private int acceptableNumber;
    private int inspectNumber;
    private double acceptableRate;
    private int employeeId;
    private String InspectDate;
}
