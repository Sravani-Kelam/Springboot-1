package com.product.demo.controller;

import com.product.demo.dto.ProductDto;
import com.product.demo.entity.ProductEntity;
import com.product.demo.service.ImplService;
import com.product.demo.service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private ImplService Service;
    @PostMapping("/saveProduct")
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto) {
        ProductDto saveProduct = Service.saveProduct(productDto);
        return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable int id){
        ProductDto productDto=Service.getByid(id);
        return new ResponseEntity<>(productDto,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<ProductDto> updateProductEntity(@PathVariable int id,@RequestBody ProductDto productDto){
        ProductDto updatedProductEntity=Service.updateProduct(id,productDto);
        return new ResponseEntity<>(updatedProductEntity,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<ProductEntity> deleteProductEntity(@PathVariable int id){
        ProductEntity productEntity=Service.deleteProductEntity(id);
        return new ResponseEntity<>(productEntity,HttpStatus.OK);
    }
}
