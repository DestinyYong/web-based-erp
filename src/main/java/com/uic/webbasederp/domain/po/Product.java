package com.uic.webbasederp.domain.po;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int id;
    private int productId;
    private String productName;
    private double price;
    private double cost;
    private String type;
    private double productLength;
    private double productWidth;
    private double productHeight;
    private int sizeOfBox;
    private int minStorageNumber;
    private String pictureAddress;
    private String state;
    private int flag;
}
