package com.uic.webbasederp.service;

import com.uic.webbasederp.domain.po.OrderProduct;

public interface OrderProductService {
    void saveOrderProduct(OrderProduct orderProduct, String date);
}
