package com.uic.webbasederp.domain.po;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Wharehouse {
    private int id;
    private int productId;
    private Integer orderNumber;
    private Integer availableNumber;
    private int minStoreNumber;

}
