package com.uic.webbasederp.mapper;

import com.uic.webbasederp.domain.po.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    void saveCustomer(Customer customer);
    List<Customer> getCustomer();
    Customer getCustomerById(int customerId);
}
