package com.uic.webbasederp.mapper;

import com.uic.webbasederp.domain.po.ProductSubproductRelation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductSubproductRelationMapper {
    void insertRelation(ProductSubproductRelation productSubproductRelation);
    List<ProductSubproductRelation> getSubProduct(int productId);
}
