package com.ws101.marino.bantillo.EcommerceApi.repository;

import com.ws101.marino.bantillo.EcommerceApi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Find products by category name
    List<Product> findByCategory_Name(String name);

    // Find products within price range
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :min AND :max")
    List<Product> findProductsByPriceRange(@Param("min") double min,
                                           @Param("max") double max);
}