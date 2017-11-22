package com.uic.webbasederp.service.impl;

import com.uic.webbasederp.domain.po.Inspection;
import com.uic.webbasederp.domain.vo.InspectionVo;
import com.uic.webbasederp.mapper.EmployeeMapper;
import com.uic.webbasederp.mapper.InspectionMapper;
import com.uic.webbasederp.mapper.ProductMapper;
import com.uic.webbasederp.service.InspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class InspectionServiceImpl implements InspectionService{

    @Autowired
    private InspectionMapper inspectionMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public void saveInspection(Inspection inspection) {
        Inspection dbInspection = inspectionMapper.getInspectionByProductId(inspection.getProductId(),inspection.getInspectDate());

        DecimalFormat df=new DecimalFormat(".##");
        if(dbInspection == null){
            inspectionMapper.saveInspection(inspection);
        }
        else {
            inspection.setAcceptableNumber(inspection.getAcceptableNumber()+dbInspection.getAcceptableNumber());
            inspection.setDefectName(dbInspection.getDefectName()+"<br>"+inspection.getDefectName());
            inspection.setDefectDescription(dbInspection.getDefectDescription()+";<br>"+inspection.getDefectDescription());
            inspection.setInspectNumber(inspection.getInspectNumber()+dbInspection.getInspectNumber());
            double acceptRate = inspection.getAcceptableNumber()*1.0/inspection.getInspectNumber()*100;
            String acceptRateStr = df.format(acceptRate);
            inspection.setAcceptableRate(Double.parseDouble(acceptRateStr));
            inspectionMapper.updateInspection(inspection);
        }
    }

    @Override
    public List<InspectionVo> listInspection(String startDate, String endDate) {
        List<Inspection> inspections = inspectionMapper.listInspection(startDate, endDate);
        List<InspectionVo> inspectionVos = new ArrayList<>();
        for(Inspection inspection : inspections){
            InspectionVo inspectionVo = new InspectionVo();
            inspectionVo.setAcceptableNumber(inspection.getAcceptableNumber());
            inspectionVo.setAcceptableRate(inspection.getAcceptableRate());
            inspectionVo.setDefectDescription(inspection.getDefectDescription());
            inspectionVo.setDefectName(inspection.getDefectName());
            inspectionVo.setEmployeeId(inspection.getEmployeeId());
            inspectionVo.setInspectDate(inspection.getInspectDate());
            inspectionVo.setProductId(inspection.getProductId());
            inspectionVo.setInspectNumber(inspection.getInspectNumber());
            inspectionVo.setProductName(productMapper.getProductById(inspection.getProductId()).getProductName());
            inspectionVo.setEmployeeName(employeeMapper.getInformationById(inspection.getEmployeeId()).getName());
            inspectionVos.add(inspectionVo);
        }
        return inspectionVos;
    }
}
