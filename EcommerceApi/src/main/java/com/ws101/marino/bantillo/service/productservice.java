package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * ProductService handles product data using in-memory storage.
 * 
 * Instead of using a database, this service stores products
 * inside a List collection while the application is running.
 * 
 * NOTE:
 * - Data will be lost when the application stops.
 * - This is only for testing or simple applications.
 */

@Service
public class ProductService {

    // In-memory list to store products
    private List<Product> productList = new ArrayList<>();
    // Auto-increment ID for new products
    private int nextId = 1;

    // Constructor (initialize sample data)
    public ProductService() {
        productList.add(new Product(1L, "Laptop", "Electronics", 50000));
        productList.add(new Product(2L, "Phone", "Electronics", 20000));
        productList.add(new Product(3L, "Shoes", "Fashion", 3000));
        productList.add(new Product(4L, "Bag", "Fashion", 1500));
        productList.add(new Product(5L, "Watch", "Accessories", 7000));
        productList.add(new Product(6L, "Headphones", "Electronics", 2500));
        productList.add(new Product(7L, "Keyboard", "Electronics", 1200));
        productList.add(new Product(8L, "Mouse", "Electronics", 800));
        productList.add(new Product(9L, "T-shirt", "Clothing", 500));
        productList.add(new Product(10L, "Jeans", "Clothing", 1200));
    }

    // 1. Get all products
    public List<Product> getAllProducts() {
        return productList;
    }

    // 2. Find by ID
    public Product getProductById(Long id) {
        return productList.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    // Creates a new product and assigns a unique ID
    public Product createProduct(Product product) {
    product.setId(nextId++);
    productList.add(product);
    return product;
}
    }

    // 4. Update product
    public Product updateProduct(Long id, Product updatedProduct) {
        Optional<Product> existingProduct = productList.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

        if (existingProduct.isPresent()) {
            Product p = existingProduct.get();
            p.setName(updatedProduct.getName());
            p.setCategory(updatedProduct.getCategory());
            p.setPrice(updatedProduct.getPrice());
            return p;
        }

        return null;
    }

    // 5. Delete product
    public boolean deleteProduct(Long id) {
        return productList.removeIf(p -> p.getId().equals(id));
    }

    // 6. Filter by category
    public List<Product> getByCategory(String category) {
        return productList.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    // 7. Filter by price range
    public List<Product> getByPriceRange(double min, double max) {
        return productList.stream()
                .filter(p -> p.getPrice() >= min && p.getPrice() <= max)
                .collect(Collectors.toList());
    }

    // 8. Search by name
    public List<Product> searchByName(String name) {
        return productList.stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}