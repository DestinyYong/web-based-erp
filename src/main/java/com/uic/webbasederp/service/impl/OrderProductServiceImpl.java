package com.uic.webbasederp.service.impl;

import com.uic.webbasederp.domain.po.OrderProduct;
import com.uic.webbasederp.mapper.OrderProductMapper;
import com.uic.webbasederp.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProductServiceImpl implements OrderProductService{
    @Autowired
    private OrderProductMapper orderProductMapper;
    @Override
    public void saveOrderProduct(OrderProduct orderProduct) {
        orderProductMapper.saveOrderProduct(orderProduct);
    }
}
