package com.uic.webbasederp.domain.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerOrderVo {
    private int orderId;
    private List<BasicProductVo> basicProductVos;
    private String customerName;
    private double totalOrderPrice;
    private String deliveryTime;
    private String latestDeliveryTime;
    private int state;
    private String createTime;
}
