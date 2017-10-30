package com.uic.webbasederp.controller;

import com.uic.webbasederp.domain.vo.OrderVo;
import com.uic.webbasederp.service.ProductService;
import com.uic.webbasederp.utilConst.CommonResultResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @ApiOperation(value = "add an product")
    @RequestMapping(value="/new",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveOrder(@RequestParam("file") MultipartFile file) throws Exception{
         String address = productService.savePicture(file);
         return address;
    }
}
