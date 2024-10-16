package com.altenshop.productManagement.service;

import com.altenshop.productManagement.entity.ProductEntity;
import com.altenshop.productManagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<ProductEntity> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public ProductEntity createProduct(ProductEntity product) {
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        return productRepository.save(product);
    }

    public ProductEntity updateProduct(Long id, ProductEntity updatedProduct) {
        return productRepository.findById(id).map(product -> {
            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            product.setCategory(updatedProduct.getCategory());
            product.setQuantity(updatedProduct.getQuantity());
            product.setInventoryStatus(updatedProduct.getInventoryStatus());
            product.setUpdatedAt(LocalDateTime.now());
            return productRepository.save(product);
        }).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public ProductEntity patchProduct(Long id, ProductEntity partialProduct) {
        return productRepository.findById(id).map(product -> {
            if (partialProduct.getName() != null) product.setName(partialProduct.getName());
            if (partialProduct.getPrice() != 0) product.setPrice(partialProduct.getPrice());
            if (partialProduct.getQuantity() != 0) product.setQuantity(partialProduct.getQuantity());
            product.setUpdatedAt(LocalDateTime.now());
            return productRepository.save(product);
        }).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }
}