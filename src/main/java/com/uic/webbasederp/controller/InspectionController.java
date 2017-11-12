package com.uic.webbasederp.controller;

import com.uic.webbasederp.domain.po.Inspection;
import com.uic.webbasederp.domain.po.OrderProduct;
import com.uic.webbasederp.domain.vo.OrderPriceVo;
import com.uic.webbasederp.domain.vo.OrderVo;
import com.uic.webbasederp.service.InspectionService;
import com.uic.webbasederp.utilConst.CommonResultResponse;
import com.uic.webbasederp.utilConst.ResponseHelper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/inspection")
public class InspectionController {
    @Autowired
    private InspectionService inspectionService;

    @ApiOperation(value = "add an product inspection")
    @RequestMapping(value="/new",method = RequestMethod.POST)
    public ResponseEntity<CommonResultResponse> saveQI(@RequestBody Inspection inspection) throws Exception{
        inspectionService.saveInspection(inspection);
        return ResponseHelper.success();
    }

    @RequestMapping(value="/list",method = RequestMethod.GET)
    public ResponseEntity<CommonResultResponse<List<Inspection>>> listQI(@RequestParam String startDate, @RequestParam String endDate) throws Exception{
        CommonResultResponse<List<Inspection>> responseBody = CommonResultResponse.buildSuccessCommonResultResponse(inspectionService.listInspection(startDate, endDate));
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
