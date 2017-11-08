package com.uic.webbasederp.mapper;

import com.uic.webbasederp.domain.po.Order;
import com.uic.webbasederp.domain.vo.OrderCostVo;
import com.uic.webbasederp.domain.vo.OrderIncomeVo;
import com.uic.webbasederp.domain.vo.OrderNumberVo;
import com.uic.webbasederp.domain.vo.OrderPriceVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    void saveOrder(Order order);
    void updateOrder(Order order);
    List<Order> listOrder();
    List<Order> listOrderByCustomerId(int customerId);
    void removeOrder(int orderId);
    List<OrderNumberVo> getOrderNumber(String startDate, String endDate);
    List<OrderPriceVo> getOrderPrice(String startDate, String endDate);
    List<OrderCostVo> getOrderCost(String startDate, String endDate);
    List<OrderIncomeVo> getOrderIncome(String startDate, String endDate);
    void changeOrderState(int orderId, int state);

}
