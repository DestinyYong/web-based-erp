package com.uic.webbasederp.service;

import com.uic.webbasederp.domain.po.Inspection;
import com.uic.webbasederp.domain.vo.InspectionVo;

import java.util.List;

public interface InspectionService {
    void saveInspection(Inspection inspection);
    List<InspectionVo> listInspection(String startDate, String endDate);
}
