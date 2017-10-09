package com.uic.webbasederp.mapper;

import com.uic.webbasederp.domain.po.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    void saveOrder(Order order);
    void updateOrder(Order order);
    List<Order> listOrder(int page);
    void removeOrder(int orderId);
    List<Order> getOrderNumber(String startDate, String endDate);
}
