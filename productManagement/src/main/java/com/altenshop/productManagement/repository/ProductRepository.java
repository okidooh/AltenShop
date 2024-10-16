package com.altenshop.productManagement.repository;

import com.altenshop.productManagement.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
