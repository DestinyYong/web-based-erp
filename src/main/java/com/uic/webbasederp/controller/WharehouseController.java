package com.uic.webbasederp.controller;

import com.uic.webbasederp.domain.po.OrderProduct;
import com.uic.webbasederp.domain.po.Wharehouse;
import com.uic.webbasederp.domain.vo.OrderVo;
import com.uic.webbasederp.domain.vo.WharehouseDetailVo;
import com.uic.webbasederp.domain.vo.WharehouseVo;
import com.uic.webbasederp.service.WharehouseService;
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
@RequestMapping(value = "/wharehouse")
public class WharehouseController {
    @Autowired
    private WharehouseService wharehouseService;

    @ApiOperation(value = "add product into wharehouse")
    @RequestMapping(value="/new",method = RequestMethod.POST)
    public ResponseEntity<CommonResultResponse> addProductIntoWharehouse(@RequestBody WharehouseVo wharehouseVo) throws Exception {
        Wharehouse wharehouse = new Wharehouse();
        wharehouse.setProductId(wharehouseVo.getProductId());
        wharehouse.setAvailableNumber(wharehouseVo.getAvailableNumber());
        wharehouseService.updateWharehouse(wharehouse);
        return ResponseHelper.success();
    }

    @ApiOperation(value = "add product into wharehouse")
    @RequestMapping(value="/all",method = RequestMethod.GET)
    public ResponseEntity<CommonResultResponse<List<WharehouseDetailVo>>> showWharehouse() throws Exception {
        List<WharehouseDetailVo> wharehouseDetailVos = wharehouseService.listWhareHouse();
        CommonResultResponse<List<WharehouseDetailVo>> responseBody = CommonResultResponse.buildSuccessCommonResultResponse(wharehouseDetailVos);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
