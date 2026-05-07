package com.ws101.marino.bantillo.EcommerceApi.model;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
