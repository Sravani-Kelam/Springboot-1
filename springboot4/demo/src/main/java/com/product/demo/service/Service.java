package com.product.demo.service;

import com.product.demo.dto.ProductDto;
import com.product.demo.entity.ProductEntity;

public interface Service {
    ProductDto saveProduct(ProductDto productDto);
    ProductDto getByid(int id);
    ProductDto updateProduct(int id, ProductDto productDto);
}
