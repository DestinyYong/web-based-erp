package com.uic.webbasederp.mapper;

import com.uic.webbasederp.domain.po.ProductSubproductRelation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductSubproductRelationMapper {
    void insertRelation(ProductSubproductRelation productSubproductRelation);
}
