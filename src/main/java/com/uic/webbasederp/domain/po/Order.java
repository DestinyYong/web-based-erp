package com.uic.webbasederp.domain.po;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private int id;
    private int orderId;
    private int customerId;
    private String deliveryTime;
    private String latestDeliveryTime;
    private double discount;
    private double totalOrderPrice;
    private int state;
    private String createTime;
}
