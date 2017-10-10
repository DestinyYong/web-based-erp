package com.uic.webbasederp.service.impl;

import com.uic.webbasederp.domain.po.Order;
import com.uic.webbasederp.domain.vo.OrderNumberVo;
import com.uic.webbasederp.domain.vo.OrderPriceVo;
import com.uic.webbasederp.mapper.OrderMapper;
import com.uic.webbasederp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public void saveOrder(Order orders) {
        orderMapper.saveOrder(orders);
    }

    @Override
    public void updateOrder(Order order) {
        orderMapper.updateOrder(order);
    }

    @Override
    public List<Order> listOrder(int page) {
        return orderMapper.listOrder((page-1)*15);
    }

    @Override
    public void removeOrder(int orderId) {

    }

    @Override
    public List<OrderNumberVo> getOrderNumber(String startDate, String endDate) throws Exception{
        return orderMapper.getOrderNumber(startDate, endDate);
    }

    @Override
    public List<OrderPriceVo> getOrderPrice(String startDate, String endDate) throws Exception {
        return orderMapper.getOrderPrice(startDate, endDate);
    }
}
