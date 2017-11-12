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
        Inspection dbInspection = inspectionMapper.getInspectionByProductId(inspection.getProductId(),inspection.getInspectDate());
        if(dbInspection == null){
            inspectionMapper.saveInspection(inspection);
        }
        else {
            inspection.setAcceptableNumber(inspection.getAcceptableNumber()+dbInspection.getAcceptableNumber());
            inspection.setDefectName(dbInspection.getDefectName()+","+inspection.getDefectName());
            inspection.setDefectDescription(dbInspection.getDefectDescription()+","+inspection.getDefectDescription());
            inspection.setInspectNumber(inspection.getInspectNumber()+dbInspection.getInspectNumber());
            inspection.setAcceptableRate(inspection.getAcceptableNumber()*1.0/inspection.getInspectNumber());
            inspectionMapper.updateInspection(inspection);
        }
    }

    @Override
    public List<Inspection> listInspection(String startDate, String endDate) {
        return inspectionMapper.listInspection(startDate, endDate);
    }
}
