package com.uic.webbasederp.service;

import com.uic.webbasederp.domain.vo.ReportRequestVo;
import com.uic.webbasederp.domain.vo.ReportVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ReportService {
    void createExcel(HttpServletRequest request, HttpServletResponse response, ReportRequestVo ReportRequestVo) throws Exception;
}
