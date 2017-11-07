package com.uic.webbasederp.mapper;

import com.uic.webbasederp.domain.po.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    void saveProduct(Product product);
    List<Product> getSubProduct();
    List<Product> getSubProductByProductId(int productId);
    List<Product> getProduct(int page);
    List<Product> getAllProduct();
    Product getProductById(int productId);
}
