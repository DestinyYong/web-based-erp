package com.uic.webbasederp.controller;

import com.uic.webbasederp.domain.po.Order;
import com.uic.webbasederp.domain.po.OrderProduct;
import com.uic.webbasederp.domain.vo.*;
import com.uic.webbasederp.service.OrderProductService;
import com.uic.webbasederp.service.OrderService;
import com.uic.webbasederp.service.ReportService;
import com.uic.webbasederp.utilConst.CommonResultResponse;
import com.uic.webbasederp.utilConst.ResponseHelper;
import com.uic.webbasederp.utilConst.ResponseMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private ReportService reportService;

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
    @ApiOperation(value = "analyze the order number")
    @RequestMapping(value="/analyze/number",method = RequestMethod.GET)
    public ResponseEntity<CommonResultResponse<List<OrderNumberVo>>> analyzeOrderNumber(@RequestParam String startDate,@RequestParam String endDate) throws Exception{
        List<OrderNumberVo> orderNumberVos = orderService.getOrderNumber(startDate, endDate);
        CommonResultResponse<List<OrderNumberVo>> responseBody = CommonResultResponse.buildSuccessCommonResultResponse(orderNumberVos);
        responseBody.setMessage(ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    @ApiOperation(value = "analyze the order price")
    @RequestMapping(value="/analyze/price",method = RequestMethod.GET)
    public ResponseEntity<CommonResultResponse<List<OrderPriceVo>>> analyzeOrderPrice(@RequestParam String startDate, @RequestParam String endDate) throws Exception{
        List<OrderPriceVo> orderPriceVos = orderService.getOrderPrice(startDate, endDate);
        CommonResultResponse<List<OrderPriceVo>> responseBody = CommonResultResponse.buildSuccessCommonResultResponse(orderPriceVos);
        responseBody.setMessage(ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    @ApiOperation(value = "analyze the order Cost")
    @RequestMapping(value="/analyze/cost",method = RequestMethod.GET)
    public ResponseEntity<CommonResultResponse<List<OrderCostVo>>> analyzeOrderCost(@RequestParam String startDate, @RequestParam String endDate) throws Exception{
        List<OrderCostVo> orderPriceVos = orderService.getOrderCost(startDate, endDate);
        CommonResultResponse<List<OrderCostVo>> responseBody = CommonResultResponse.buildSuccessCommonResultResponse(orderPriceVos);
        responseBody.setMessage(ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    @ApiOperation(value = "analyze the order income")
    @RequestMapping(value="/analyze/income",method = RequestMethod.GET)
    public ResponseEntity<CommonResultResponse<List<OrderIncomeVo>>> analyzeOrderIncome(@RequestParam String startDate, @RequestParam String endDate) throws Exception{
        List<OrderIncomeVo> orderPriceVos = orderService.getOrderIncome(startDate, endDate);
        CommonResultResponse<List<OrderIncomeVo>> responseBody = CommonResultResponse.buildSuccessCommonResultResponse(orderPriceVos);
        responseBody.setMessage(ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    @ApiOperation(value = "list the order")
    @RequestMapping(value="/all",method = RequestMethod.GET)
    public ResponseEntity<CommonResultResponse<List<CustomerOrderVo>>> getOrder() throws Exception{
        List<CustomerOrderVo> orders = orderService.listOrder();
        CommonResultResponse<List<CustomerOrderVo>> responseBody = CommonResultResponse.buildSuccessCommonResultResponse(orders);
        responseBody.setMessage(ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    @ApiOperation(value = "get the customer order")
    @RequestMapping(value="/customer",method = RequestMethod.GET)
    public ResponseEntity<CommonResultResponse<List<CustomerOrderVo>>> getOrder(@RequestParam int customerId) throws Exception{
        List<CustomerOrderVo> orders = orderService.listOrderByCustomerId(customerId);
        CommonResultResponse<List<CustomerOrderVo>> responseBody = CommonResultResponse.buildSuccessCommonResultResponse(orders);
        responseBody.setMessage(ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    @ApiOperation(value = "change the order state")
    @RequestMapping(value="/finish",method = RequestMethod.POST)
    public ResponseEntity<CommonResultResponse> changeOrderState(@RequestParam int orderId, @RequestParam int state) throws Exception{
        orderService.changeOrderState(orderId,state);
        return ResponseHelper.success();
    }

    @ApiOperation(value = "create the order report")
    @RequestMapping(value="/excel",method = RequestMethod.POST)
    public ResponseEntity<CommonResultResponse> createExcel(@RequestBody List<ReportVo> reportVos) throws Exception{
        reportService.createExcel(reportVos);
        return ResponseHelper.success();
    }
}
