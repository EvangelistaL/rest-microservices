package com.microservices.productapi.api.usecase;

import com.microservices.productapi.internal.entity.Product;

public interface CreateProduct {

    Product execute(Product product);
}
