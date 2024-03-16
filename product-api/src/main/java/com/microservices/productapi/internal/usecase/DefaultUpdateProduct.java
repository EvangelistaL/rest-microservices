package com.microservices.productapi.internal.usecase;

import com.microservices.productapi.api.model.ProductBody;
import com.microservices.productapi.api.specification.ProductSpecification;
import com.microservices.productapi.api.usecase.RetrieveProduct;
import com.microservices.productapi.api.usecase.UpdateProduct;
import com.microservices.productapi.internal.entity.Product;
import com.microservices.productapi.internal.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultUpdateProduct implements UpdateProduct {

    private final RetrieveProduct retrieveProduct;

    private final ProductRepository productRepository;

    @Override
    public Product execute(Long productId, ProductBody productBody) {
        Product productToUpdate = this.findProduct(productId);
        this.updatingProduct(productToUpdate, productBody);
        return this.productRepository.save(productToUpdate);
    }

    private Product findProduct(Long productId){
        return this.retrieveProduct.execute(ProductSpecification.findProductById(productId), Pageable.unpaged())
                .stream()
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    private void updatingProduct(Product product, ProductBody productBody){
        product.setProductIdentifier(Optional.ofNullable(productBody.productIdentifier())
                .orElse(product.getProductIdentifier()));
        product.setName(Optional.ofNullable(productBody.name())
                .orElse(product.getName()));
        product.setDescription(Optional.ofNullable(productBody.description())
                .orElse(product.getDescription()));
        product.setPrice(Optional.ofNullable(productBody.price())
                .orElse(product.getPrice()));
    }
}
