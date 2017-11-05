package com.uic.webbasederp.mapper;

import com.uic.webbasederp.domain.po.Order;
import com.uic.webbasederp.domain.po.OrderProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderProductMapper {
    void saveOrderProduct(OrderProduct orderProduct);
    List<OrderProduct> getProductIdByOrderId(int orderId);
}
