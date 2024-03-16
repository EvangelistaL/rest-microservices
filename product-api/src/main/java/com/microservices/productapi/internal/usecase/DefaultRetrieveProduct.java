package com.microservices.productapi.internal.usecase;

import com.microservices.productapi.api.usecase.RetrieveProduct;
import com.microservices.productapi.internal.entity.Product;
import com.microservices.productapi.internal.repository.ProductRepository;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultRetrieveProduct implements RetrieveProduct {

    private final ProductRepository productRepository;

    @Override
    public Page<Product> execute(Predicate predicate, Pageable pageable) {
        if (predicate == null){
            return this.productRepository.findAll(pageable);
        }
        return this.productRepository.findAll(predicate, pageable);
    }
}
