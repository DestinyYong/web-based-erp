package com.uic.webbasederp.domain.vo;

import com.uic.webbasederp.domain.po.Order;
import com.uic.webbasederp.domain.po.OrderProduct;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderVo {
    private Order order;
    private List<OrderProduct> orderProducts;
}
