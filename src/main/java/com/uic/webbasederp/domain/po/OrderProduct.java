package com.uic.webbasederp.domain.po;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderProduct {
    private Integer id;
    private Integer orderId;
    private Integer productId;
    private Integer number;
    private Double price;
}
