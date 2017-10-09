package com.uic.webbasederp.mapper;

import com.uic.webbasederp.domain.po.OrderProduct;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderProductMapper {
    void saveOrderProduct(OrderProduct orderProduct);
}
