package com.uic.webbasederp.domain.vo;

import com.uic.webbasederp.domain.po.ProductSubproductRelation;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    private int flag;
    private List<ProductSubproductRelation> productSubproductRelations;
}
