package com.ws101.marino.bantillo.EcommerceApi.controller;

import com.ws101.marino.bantillo.EcommerceApi.model.Product;
import com.ws101.marino.bantillo.EcommerceApi.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for handling product-related API requests.
 *
 * This class provides endpoints for creating, retrieving,
 * updating, and deleting products. It communicates with
 * the ProductService to perform business logic operations.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    /**
     * Constructor for ProductController using dependency injection.
     *
     * @param productService the service layer used to manage products
     */
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Retrieves all products.
     *
     * @return ResponseEntity containing a list of all products
     *         with HTTP status 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product to retrieve
     * @return ResponseEntity containing the product if found
     *         with HTTP status 200 (OK),
     *         or 404 (Not Found) if no product exists
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Creates a new product.
     *
     * @param product the product to be created
     * @return ResponseEntity containing the created product
     *         with HTTP status 201 (Created)
     */
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.status(201).body(productService.createProduct(product));
    }

    /**
     * Updates an existing product completely.
     *
     * @param id the ID of the product to update
     * @param updated the updated product data
     * @return ResponseEntity containing the updated product
     *         with HTTP status 200 (OK),
     *         or 404 (Not Found) if the product does not exist
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updated) {
        Product result = productService.updateProduct(id, updated);
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to delete
     * @return ResponseEntity with HTTP status 204 (No Content)
     *         if deletion is successful,
     *         or 404 (Not Found) if the product does not exist
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        boolean deleted = productService.deleteProduct(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}