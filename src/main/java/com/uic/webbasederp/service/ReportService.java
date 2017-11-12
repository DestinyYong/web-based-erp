package com.uic.webbasederp.service;

import com.uic.webbasederp.domain.vo.ReportVo;

import java.util.List;

public interface ReportService {
    void createExcel(List<ReportVo> reportVos) throws Exception;
}
