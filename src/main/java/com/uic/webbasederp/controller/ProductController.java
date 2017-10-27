package com.uic.webbasederp.controller;

import com.uic.webbasederp.domain.vo.ProductVo;
import com.uic.webbasederp.service.ProductService;
import com.uic.webbasederp.utilConst.CommonResultResponse;
import com.uic.webbasederp.utilConst.ResponseHelper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ApiOperation(value = "add a product")
    @RequestMapping(value="/new",method = RequestMethod.POST)
    public ResponseEntity<CommonResultResponse> getImageUrl(@RequestBody ProductVo productVo) throws Exception{
        productService.insertProduct(productVo);
        return ResponseHelper.success();
    }

}
