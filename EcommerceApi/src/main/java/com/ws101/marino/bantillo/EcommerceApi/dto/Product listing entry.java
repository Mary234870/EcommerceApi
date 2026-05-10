package com.ws101.marino.bantillo.EcommerceApi.exception;package com.ws101.marino.bantillo.EcommerceApi.exception;

public record ProductListingEntry(
    Long prodId,
    String prodName,
    Double prodPrice
) {}
