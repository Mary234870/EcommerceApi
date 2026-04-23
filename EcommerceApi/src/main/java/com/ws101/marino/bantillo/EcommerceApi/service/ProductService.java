package com.ws101.marino.bantillo.EcommerceApi.service;

import com.ws101.marino.bantillo.EcommerceApi.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service class for managing product-related operations.
 *
 * This class handles business logic such as creating,
 * retrieving, updating, deleting, and filtering products.
 * It acts as an intermediary between the controller layer
 * and the in-memory data storage.
 */
@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private long nextId = 1;

    /**
     * Default constructor that initializes sample product data.
     */
    public ProductService() {
        products.add(new Product(nextId++, "Phone", "Smartphone", 10000, "Electronics", 10, ""));
        products.add(new Product(nextId++, "Laptop", "Gaming Laptop", 50000, "Electronics", 5, ""));
    }

    /**
     * Retrieves all available products.
     *
     * @return a list of all products in the system;
     *         returns an empty list if no products exist
     */
    public List<Product> getAllProducts() {
        return products;
    }

    /**
     * Retrieves a product by its unique ID.
     *
     * @param id the ID of the product to retrieve
     * @return an Optional containing the found product,
     *         or empty if no product matches the given ID
     * @throws IllegalArgumentException if id is null
     */
    public Optional<Product> getProductById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }

        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    /**
     * Creates and adds a new product.
     *
     * @param product the product to be created
     * @return the created product with an assigned ID
     * @throws IllegalArgumentException if product is null
     */
    public Product createProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }

        product.setId(nextId++);
        products.add(product);
        return product;
    }

    /**
     * Updates an existing product completely.
     *
     * Replaces all fields of the product with the given updated values.
     *
     * @param id the ID of the product to update
     * @param updatedProduct the new product data
     * @return the updated product, or null if no product is found
     * @throws IllegalArgumentException if id or updatedProduct is null
     */
    public Product updateProduct(Long id, Product updatedProduct) {
        if (id == null || updatedProduct == null) {
            throw new IllegalArgumentException("ID and updated product cannot be null");
        }

        for (Product p : products) {
            if (p.getId().equals(id)) {
                p.setName(updatedProduct.getName());
                p.setDescription(updatedProduct.getDescription());
                p.setPrice(updatedProduct.getPrice());
                p.setCategory(updatedProduct.getCategory());
                p.setStockQuantity(updatedProduct.getStockQuantity());
                p.setImageUrl(updatedProduct.getImageUrl());
                return p;
            }
        }
        return null;
    }

    /**
     * Partially updates an existing product.
     *
     * Only non-null or non-zero fields in the updated object
     * will be applied to the existing product.
     *
     * @param id the ID of the product to update
     * @param updated the product data containing fields to update
     * @return the updated product, or null if no product is found
     * @throws IllegalArgumentException if id or updated is null
     */
    public Product partialUpdateProduct(Long id, Product updated) {
        if (id == null || updated == null) {
            throw new IllegalArgumentException("ID and updated product cannot be null");
        }

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

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to delete
     * @return true if the product was successfully deleted,
     *         false if no matching product was found
     * @throws IllegalArgumentException if id is null
     */
    public boolean deleteProduct(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }

        return products.removeIf(p -> p.getId().equals(id));
    }

    /**
     * Filters products based on a given type and value.
     *
     * Supported filter types:
     * - "category": filters by product category
     * - "name": filters by product name (case-insensitive)
     *
     * @param type the type of filter (e.g., "category", "name")
     * @param value the value to match against
     * @return a list of filtered products; returns all products
     *         if the type is not recognized
     * @throws IllegalArgumentException if type or value is null
     */
    public List<Product> filterProducts(String type, String value) {
        if (type == null || value == null) {
            throw new IllegalArgumentException("Type and value cannot be null");
        }

        return products.stream()
                .filter(p -> {
                    if (type.equalsIgnoreCase("category")) {
                        return p.getCategory().equalsIgnoreCase(value);
                    }
                    if (type.equalsIgnoreCase("name")) {
                        return p.getName().toLowerCase().contains(value.toLowerCase());
                    }
                    return true;
                })
                .toList();
    }
}