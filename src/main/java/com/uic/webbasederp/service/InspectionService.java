package com.uic.webbasederp.service;

import com.uic.webbasederp.domain.po.Inspection;

import java.util.List;

public interface InspectionService {
    void saveInspection(Inspection inspection);
    List<Inspection> listInspection(String startDate, String endDate);
}
