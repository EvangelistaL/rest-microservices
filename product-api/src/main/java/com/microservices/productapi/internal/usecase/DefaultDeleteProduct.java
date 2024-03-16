package com.microservices.productapi.internal.usecase;

import com.microservices.productapi.api.specification.ProductSpecification;
import com.microservices.productapi.api.usecase.DeleteProduct;
import com.microservices.productapi.api.usecase.RetrieveProduct;
import com.microservices.productapi.internal.entity.Product;
import com.microservices.productapi.internal.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class DefaultDeleteProduct implements DeleteProduct {

    private final RetrieveProduct retrieveProduct;

    private final ProductRepository productRepository;

    @Override
    public void execute(Long productId) {
        Product product = this.retrieveProduct.execute(ProductSpecification.findProductById(productId), Pageable.unpaged())
                .stream()
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        this.productRepository.delete(product);
    }
}
