package com.uic.webbasederp.service;

import com.uic.webbasederp.domain.po.Product;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
    String savePicture(MultipartFile multipartFile) throws Exception;
    void insertProduct(Product product);

}
