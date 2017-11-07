package com.uic.webbasederp.service;

import com.uic.webbasederp.domain.po.Product;
import com.uic.webbasederp.domain.vo.ProductVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    void insertProduct(ProductVo productVo)throws Exception;
    List<Product> getSubProduct();
    List<Product> getSubproductByProductID(int productId);
    List<Product> getProduct(int page);
    List<Product> getAllProduct();

}
