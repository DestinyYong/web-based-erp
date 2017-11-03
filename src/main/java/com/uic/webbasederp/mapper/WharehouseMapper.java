package com.uic.webbasederp.mapper;

import com.uic.webbasederp.domain.po.Wharehouse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WharehouseMapper {
    void addProductIntoWharehouse(Wharehouse wharehouse);
    void updateWharehouse(Wharehouse wharehouse);
    List<Wharehouse> listWhareHouse(int page);
}
