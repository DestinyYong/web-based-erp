package com.uic.webbasederp.service.impl;

import com.uic.webbasederp.domain.po.Customer;
import com.uic.webbasederp.mapper.CustomerMapper;
import com.uic.webbasederp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public void saveCustomer(Customer customer) {
        customerMapper.saveCustomer(customer);
    }

    @Override
    public List<Customer> getCustomer() {
        return customerMapper.getCustomer();
    }
}
