package com.uic.webbasederp.service.impl;

import com.uic.webbasederp.domain.po.Inspection;
import com.uic.webbasederp.mapper.InspectionMapper;
import com.uic.webbasederp.service.InspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InspectionServiceImpl implements InspectionService{

    @Autowired
    private InspectionMapper inspectionMapper;
    @Override
    public void saveInspection(Inspection inspection) {
        inspectionMapper.saveInspection(inspection);
    }

    @Override
    public List<Inspection> listInspection(String startDate, String endDate) {
        return inspectionMapper.listInspection(startDate, endDate);
    }
}
