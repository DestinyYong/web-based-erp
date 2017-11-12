package com.uic.webbasederp.mapper;

import com.uic.webbasederp.domain.po.Inspection;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InspectionMapper {
    void saveInspection(Inspection inspection);
    List<Inspection> listInspection(String startDate, String endDate);
    Inspection getInspectionByProductId(int productId, String date);
    void updateInspection(Inspection inspection);
}
