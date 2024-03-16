package com.microservices.productapi.api.usecase;

import com.microservices.productapi.api.model.ProductBody;
import com.microservices.productapi.internal.entity.Product;

public interface UpdateProduct {

    Product execute(Long productId, ProductBody product);
}
