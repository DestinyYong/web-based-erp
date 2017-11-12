package com.uic.webbasederp.domain.po;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Inspection {
    private int id;
    private int productId;
    private String defectName;
    private String defectDescription;
    private int acceptableNumber;
    private int inspectNumber;
    private double acceptableRate;
    private int employeeId;
    private String InspectDate;
}
