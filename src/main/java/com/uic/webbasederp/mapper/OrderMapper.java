package com.uic.webbasederp.mapper;

import com.uic.webbasederp.domain.po.Order;
import com.uic.webbasederp.domain.vo.OrderNumberVo;
import com.uic.webbasederp.domain.vo.OrderPriceVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    void saveOrder(Order order);
    void updateOrder(Order order);
    List<Order> listOrder(int page);
    void removeOrder(int orderId);
    List<OrderNumberVo> getOrderNumber(String startDate, String endDate);
    List<OrderPriceVo> getOrderPrice(String startDate, String endDate);
}
