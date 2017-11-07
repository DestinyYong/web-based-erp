package com.uic.webbasederp.service;

import com.uic.webbasederp.domain.po.Customer;

import java.util.List;

public interface CustomerService {
    void saveCustomer(Customer customer);
    List<Customer> getCustomer();
}
