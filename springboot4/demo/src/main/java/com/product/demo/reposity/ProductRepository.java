package com.product.demo.reposity;

import com.product.demo.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
Optional<ProductEntity> findByid(int id);
}
