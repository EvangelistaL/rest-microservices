package com.microservices.productapi.api.usecase;

import com.microservices.productapi.internal.entity.Product;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RetrieveProduct {

    Page<Product> execute(Predicate predicate, Pageable pageable);
}
