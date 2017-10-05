package com.uic.webbasederp.service;

import com.uic.webbasederp.domain.po.Order;

import java.util.List;

public interface OrderService {
    void saveOrder(Order order);
    void updateOrder(Order order);
    List<Order> listOrder(int page);
    void removeOrder(int orderId);
}
