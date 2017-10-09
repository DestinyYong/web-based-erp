package com.uic.webbasederp.controller;

import com.uic.webbasederp.domain.po.Order;
import com.uic.webbasederp.domain.po.OrderProduct;
import com.uic.webbasederp.domain.vo.OrderVo;
import com.uic.webbasederp.service.OrderProductService;
import com.uic.webbasederp.service.OrderService;
import com.uic.webbasederp.utilConst.CommonResultResponse;
import com.uic.webbasederp.utilConst.ResponseHelper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderProductService orderProductService;
    @ApiOperation(value = "add an order")
    @RequestMapping(value="/new",method = RequestMethod.POST)
    public ResponseEntity<CommonResultResponse> saveOrder(@RequestBody OrderVo orderVo) throws Exception{
        orderService.saveOrder(orderVo.getOrder());
        List<OrderProduct> orderProducts = orderVo.getOrderProducts();
        for(OrderProduct orderProduct : orderProducts){
            orderProductService.saveOrderProduct(orderProduct);
        }
        return ResponseHelper.success();
    }

}
