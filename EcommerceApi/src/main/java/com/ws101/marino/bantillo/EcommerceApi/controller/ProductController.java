package com.ws101.marino.bantillo.EcommerceApi.controller;

import com.ws101.marino.bantillo.EcommerceApi.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;



public class ProductController {

    private List<Product> products = new ArrayList<>();
    private long nextId = 1;

    public List<Product> getAllProducts() {
        return products;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public Product createProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    public Product updateProduct(Long id, Product updated) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                p.setName(updated.getName());
                p.setDescription(updated.getDescription());
                p.setPrice(updated.getPrice());
                p.setCategory(updated.getCategory());
                p.setStockQuantity(updated.getStockQuantity());
                p.setImageUrl(updated.getImageUrl());
                return p;
            }
        }
        return null;
    }

    public Product partialUpdateProduct(Long id, Product updated) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                if (updated.getName() != null) p.setName(updated.getName());
                if (updated.getDescription() != null) p.setDescription(updated.getDescription());
                if (updated.getPrice() != 0) p.setPrice(updated.getPrice());
                if (updated.getCategory() != null) p.setCategory(updated.getCategory());
                if (updated.getStockQuantity() != 0) p.setStockQuantity(updated.getStockQuantity());
                if (updated.getImageUrl() != null) p.setImageUrl(updated.getImageUrl());
                return p;
            }
        }
        return null;
    }

    public boolean deleteProduct(Long id) {
        return products.removeIf(p -> p.getId().equals(id));
    }
}