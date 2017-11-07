package com.uic.webbasederp.service;

import com.uic.webbasederp.domain.po.Order;
import com.uic.webbasederp.domain.vo.CustomerOrderVo;
import com.uic.webbasederp.domain.vo.OrderNumberVo;
import com.uic.webbasederp.domain.vo.OrderPriceVo;

import java.util.List;

public interface OrderService {
    void saveOrder(Order order);
    void updateOrder(Order order);
    List<CustomerOrderVo> listOrder();
    List<CustomerOrderVo> listOrderByCustomerId(int customerId);
    void removeOrder(int orderId);
    List<OrderNumberVo> getOrderNumber(String startDate, String endDate) throws Exception;
    List<OrderPriceVo> getOrderPrice(String startDate,String endDate) throws Exception;
    void changeOrderState(int orderId, int state);
}
