package com.uic.webbasederp.service.impl;

import com.uic.webbasederp.domain.po.Order;
import com.uic.webbasederp.domain.po.OrderProduct;
import com.uic.webbasederp.domain.po.Product;
import com.uic.webbasederp.domain.po.Wharehouse;
import com.uic.webbasederp.domain.vo.BasicProductVo;
import com.uic.webbasederp.domain.vo.CustomerOrderVo;
import com.uic.webbasederp.domain.vo.OrderNumberVo;
import com.uic.webbasederp.domain.vo.OrderPriceVo;
import com.uic.webbasederp.mapper.*;
import com.uic.webbasederp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private WharehouseMapper wharehouseMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private OrderProductMapper orderProductMapper;
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public void saveOrder(Order orders) {
        orderMapper.saveOrder(orders);
    }

    @Override
    public void updateOrder(Order order) {
        orderMapper.updateOrder(order);
    }

    @Override
    public List<CustomerOrderVo> listOrder() {

        List<Order> orders = orderMapper.listOrder();
        List<CustomerOrderVo> customerOrderVos = new ArrayList<>();
        for(Order order : orders){
            CustomerOrderVo customerOrderVo = new CustomerOrderVo();
            customerOrderVo.setOrderId(order.getOrderId());
            customerOrderVo.setCreateTime(order.getCreateTime());
            customerOrderVo.setDeliveryTime(order.getDeliveryTime());
            customerOrderVo.setLatestDeliveryTime(order.getLatestDeliveryTime());
            customerOrderVo.setState(order.getState());
            customerOrderVo.setCustomerName(customerMapper.getCustomerById(order.getCustomerId()).getCompany());
            customerOrderVo.setTotalOrderPrice(order.getTotalOrderPrice());

            List<BasicProductVo> basicProductVos = new ArrayList<>();
            BasicProductVo basicProductVo = new BasicProductVo();
            List<OrderProduct> orderProducts = orderProductMapper.getProductIdByOrderId(order.getOrderId());
            for(OrderProduct orderProduct : orderProducts){
                basicProductVo.setNumber(orderProduct.getNumber());
                basicProductVo.setPrice(orderProduct.getPrice());
                basicProductVo.setProductName(productMapper.getProductById(orderProduct.getProductId()).getProductName());
                basicProductVos.add(basicProductVo);
            }
            customerOrderVo.setBasicProductVos(basicProductVos);
            customerOrderVos.add(customerOrderVo);
        }
        return customerOrderVos;
    }

    @Override
    public List<CustomerOrderVo> listOrderByCustomerId(int customerId) {

        List<Order> orders = orderMapper.listOrderByCustomerId(customerId);
        List<CustomerOrderVo> customerOrderVos = new ArrayList<>();
        for(Order order : orders){
            CustomerOrderVo customerOrderVo = new CustomerOrderVo();
            customerOrderVo.setOrderId(order.getOrderId());
            customerOrderVo.setCreateTime(order.getCreateTime());
            customerOrderVo.setDeliveryTime(order.getDeliveryTime());
            customerOrderVo.setLatestDeliveryTime(order.getLatestDeliveryTime());
            customerOrderVo.setState(order.getState());
            customerOrderVo.setCustomerName(customerMapper.getCustomerById(order.getCustomerId()).getCompany());
            customerOrderVo.setTotalOrderPrice(order.getTotalOrderPrice());

            List<BasicProductVo> basicProductVos = new ArrayList<>();
            BasicProductVo basicProductVo = new BasicProductVo();
            List<OrderProduct> orderProducts = orderProductMapper.getProductIdByOrderId(order.getOrderId());
            for(OrderProduct orderProduct : orderProducts){
                basicProductVo.setNumber(orderProduct.getNumber());
                basicProductVo.setPrice(orderProduct.getPrice());
                basicProductVo.setProductName(productMapper.getProductById(orderProduct.getProductId()).getProductName());
                basicProductVos.add(basicProductVo);
            }
            customerOrderVo.setBasicProductVos(basicProductVos);
            customerOrderVos.add(customerOrderVo);
        }
        return customerOrderVos;
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

    @Override
    public void changeOrderState(int orderId, int state) {
        orderMapper.changeOrderState(orderId, state);
        List<OrderProduct> orderProducts = orderProductMapper.getProductIdByOrderId(orderId);
        for(OrderProduct orderProduct : orderProducts){
            int productId = orderProduct.getProductId();
            int number = orderProduct.getNumber();
            List<Product> products = productMapper.getSubProductByProductId(productId);
            for(Product product : products){
                Wharehouse dbWharehouse = wharehouseMapper.listWhareHouseById(product.getProductId());
                Wharehouse wharehouse = new Wharehouse();
                wharehouse.setProductId(product.getProductId());
                wharehouse.setOrderNumber(dbWharehouse.getOrderNumber() - number);
                wharehouseMapper.updateWharehouse(wharehouse);
            }
        }

    }
}
