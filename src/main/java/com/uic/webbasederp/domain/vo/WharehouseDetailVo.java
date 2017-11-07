package com.uic.webbasederp.domain.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WharehouseDetailVo {
    private int id;
    private int productId;
    private String productName;
    private Integer orderNumber;
    private Integer availableNumber;
    private int minStoreNumber;

}
