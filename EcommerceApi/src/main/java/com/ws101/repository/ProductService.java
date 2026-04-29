package com.ws101.marino.bantillo.EcommerceApi.service;

import com.ws101.marino.bantillo.EcommerceApi.model.Product;
import com.ws101.marino.bantillo.EcommerceApi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // CREATE
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // READ ALL
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // READ BY ID
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // DELETE
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // UPDATE (optional but useful)
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    // CUSTOM: category filter
    public List<Product> getByCategory(String categoryName) {
        return productRepository.findByCategory_Name(categoryName);
    }

    // CUSTOM: price range
    public List<Product> getByPriceRange(double min, double max) {
        return productRepository.findProductsByPriceRange(min, max);
    }
}