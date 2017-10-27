package com.uic.webbasederp.domain.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductVo {
    private String base64Image;
    private String fileType;
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
    private String state;
}
