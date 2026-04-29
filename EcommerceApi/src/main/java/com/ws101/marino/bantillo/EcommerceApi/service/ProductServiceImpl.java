package com.ws101.marino.bantillo.EcommerceApi.service;

import org.springframework.stereotype.Service;

import com.ws101.marino.bantillo.EcommerceApi.model.Product;
import com.ws101.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

public @Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
    }
} {
    
}
