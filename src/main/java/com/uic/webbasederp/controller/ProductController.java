package com.uic.webbasederp.controller;


import com.uic.webbasederp.domain.po.Product;
import com.uic.webbasederp.domain.vo.ProductVo;
import com.uic.webbasederp.service.ProductService;
import com.uic.webbasederp.utilConst.CommonResultResponse;
import com.uic.webbasederp.utilConst.ResponseHelper;
import com.uic.webbasederp.utilConst.ResponseMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ApiOperation(value = "add a product")
    @RequestMapping(value="/new",method = RequestMethod.POST)
    public ResponseEntity<CommonResultResponse> saveProduct(@RequestBody ProductVo productVo) throws Exception{
        productService.insertProduct(productVo);
        return ResponseHelper.success();
    }

    @ApiOperation(value = "list all subproduct")
    @RequestMapping(value="/sub",method = RequestMethod.GET)
    public ResponseEntity<CommonResultResponse<List<Product>>> getSubproduct() throws Exception{
        CommonResultResponse<List<Product>> responseBody = CommonResultResponse.buildSuccessCommonResultResponse(productService.getSubProduct());
        responseBody.setMessage(ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    @ApiOperation(value = "list all subproduct by productId")
    @RequestMapping(value="/detail",method = RequestMethod.GET)
    public ResponseEntity<CommonResultResponse<List<Product>>> getSubproductByProductId(@RequestParam int productId) throws Exception{
        CommonResultResponse<List<Product>> responseBody = CommonResultResponse.buildSuccessCommonResultResponse(productService.getSubproductByProductID(productId));
        responseBody.setMessage(ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    @ApiOperation(value = "list current page product")
    @RequestMapping(value="/all",method = RequestMethod.GET)
    public ResponseEntity<CommonResultResponse<List<Product>>> getProduct(@RequestParam int page) throws Exception{
        CommonResultResponse<List<Product>> responseBody = CommonResultResponse.buildSuccessCommonResultResponse(productService.getProduct(page));
        responseBody.setMessage(ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    @ApiOperation(value = "list all product")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<CommonResultResponse<List<Product>>> getAllProduct() throws Exception{
        CommonResultResponse<List<Product>> responseBody = CommonResultResponse.buildSuccessCommonResultResponse(productService.getAllProduct());
        responseBody.setMessage(ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

}
