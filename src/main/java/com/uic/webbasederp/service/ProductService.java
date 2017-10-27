package com.uic.webbasederp.service;

import com.uic.webbasederp.domain.po.Product;
import com.uic.webbasederp.domain.vo.ProductVo;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
    void insertProduct(ProductVo productVo)throws Exception;

}
