package com.uic.webbasederp.domain.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReportRequestVo {
    List<ReportVo> reportVos;
    String fileName;
}
