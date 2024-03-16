package com.microservices.productapi.internal.controller;

import com.microservices.productapi.api.controller.ProductController;
import com.microservices.productapi.api.model.ProductBody;
import com.microservices.productapi.api.specification.ProductSpecification;
import com.microservices.productapi.api.usecase.CreateProduct;
import com.microservices.productapi.api.usecase.DeleteProduct;
import com.microservices.productapi.api.usecase.RetrieveProduct;
import com.microservices.productapi.api.usecase.UpdateProduct;
import com.microservices.productapi.internal.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
@ConditionalOnSingleCandidate(ProductController.class)
public class DefaultProductController implements ProductController {

    private final CreateProduct createProduct;

    private final DeleteProduct deleteProduct;

    private final RetrieveProduct retrieveProduct;

    private  final UpdateProduct updateProduct;

    @Override
    public Page<Product> retrieveAllProducts(Pageable pageable) {
        Page<Product> products = this.retrieveProduct.execute(null, pageable);
        if (products.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return products;
    }

    @Override
    public Product retrieveProductById(Long productId) {
        return this.retrieveProduct.execute(ProductSpecification.findProductById(productId), Pageable.unpaged())
                .stream()
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Product retrieveProductByProductIdentifier(String productIdentifier) {
        return this.retrieveProduct.execute(ProductSpecification.findByProductIdentifier(productIdentifier), Pageable.unpaged())
                .stream()
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Page<Product> retrieveProductByCategoryId(Long categoryId, Pageable pageable) {
        Page<Product> products = this.retrieveProduct.execute(ProductSpecification.findByCategory(categoryId), pageable);
        if (products.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return this.createProduct.execute(product);
    }

    @Override
    public Product updateProduct(ProductBody productBody, Long productId) {
        return this.updateProduct.execute(productId, productBody);
    }

    @Override
    public void deleteProduct(Long productId) {
        this.deleteProduct.execute(productId);
    }
}
