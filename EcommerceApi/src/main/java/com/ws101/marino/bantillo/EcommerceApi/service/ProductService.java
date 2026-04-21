package com.ws101.marino.bantillo.EcommerceApi.service;
import com.ws101.marino.bantillo.EcommerceApi.model.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private long nextId = 1;

    // Constructor with sample data
    public ProductService() {
        products.add(new Product(nextId++, "Phone", "Smartphone", 10000, "Electronics", 10, ""));
        products.add(new Product(nextId++, "Laptop", "Gaming Laptop", 50000, "Electronics", 5, ""));
    }

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

    public Product updateProduct(Long id, Product updatedProduct) {
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

    public List<Product> filterProducts(String type, String value) {
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
