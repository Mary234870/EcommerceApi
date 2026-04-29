package com.ws101.marino.bantillo.EcommerceApi.service;

import com.ws101.marino.bantillo.EcommerceApi.model.Product;
import com.ws101.marino.bantillo.EcommerceApi.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    // ✅ GET ALL
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // ✅ GET BY ID (FIXED - no Optional anymore)
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
    }

    // ✅ CREATE
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // ✅ UPDATE
    public Product updateProduct(Long id, Product updatedProduct) {
        Product existing = getProductById(id);

        existing.setName(updatedProduct.getName());
        existing.setDescription(updatedProduct.getDescription());
        existing.setPrice(updatedProduct.getPrice());
        existing.setCategory(updatedProduct.getCategory());
        existing.setStockQuantity(updatedProduct.getStockQuantity());
        existing.setImageUrl(updatedProduct.getImageUrl());

        return productRepository.save(existing);
    }

    // ✅ DELETE
    public void deleteProduct(Long id) {
        Product existing = getProductById(id);
        productRepository.delete(existing);
    }

    // ✅ FILTER BY CATEGORY (DB)
    public List<Product> getProductsByCategory(String categoryName) {
        return productRepository.findByCategory_Name(categoryName);
    }
}