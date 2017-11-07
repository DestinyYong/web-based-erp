package com.uic.webbasederp.domain.po;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    private int id;
    private int customerId;
    private String company;
    private String country;
    private String address;
    private String telephone;

}
