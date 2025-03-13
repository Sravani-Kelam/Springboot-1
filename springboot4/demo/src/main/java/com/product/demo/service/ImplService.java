package com.product.demo.service;

import com.product.demo.dto.ProductDto;
import com.product.demo.entity.ProductEntity;
import com.product.demo.reposity.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
//@AllArgsConstructor

public class ImplService implements Service {

    @Autowired
    private ProductRepository productrepo;

    public ProductDto saveProduct(ProductDto productDto) {
        ProductEntity product = new ProductEntity(
                productDto.getId(),
                productDto.getName(),
                productDto.getPrice(),
                productDto.getNetquantity()
        );
        ProductEntity saveProduct = productrepo.save(product);

        ProductDto saveproductDto = new ProductDto(
                saveProduct.getId(),
                saveProduct.getName(),
                saveProduct.getPrice(),
                saveProduct.getNetquantity()
        );
        return saveproductDto;
    }
    @Override
    public ProductDto getByid(int id) {
        ProductEntity productEntity = productrepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return new ProductDto(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getPrice(),
                productEntity.getNetquantity()
        );
    }
    public ProductDto updateProduct(int id, ProductDto productDto){
        ProductEntity existingProductEntity=productrepo.findById(id)
                .orElseThrow(()->new RuntimeException("Product not found by id:"+id));

        existingProductEntity.setName(productDto.getName());
        existingProductEntity.setPrice(productDto.getPrice());
        existingProductEntity.setNetquantity(productDto.getNetquantity());
        ProductEntity updatedProductEntity=productrepo.save(existingProductEntity);
        return new ProductDto(
                updatedProductEntity.getId(),
                updatedProductEntity.getName(),
                updatedProductEntity.getPrice(),
                updatedProductEntity.getNetquantity()
        );
    }
    public ProductEntity deleteProductEntity(int id){
        ProductEntity existingProductEntity=productrepo.findById(id)
                .orElseThrow(()->new RuntimeException("Product is not found by id:"+id));
        productrepo.deleteById(id);
        return existingProductEntity;
    }
}