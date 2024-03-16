package com.microservices.productapi.api.controller;

import com.microservices.productapi.api.model.ProductBody;
import com.microservices.productapi.internal.entity.Product;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/products")
public interface ProductController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Page<Product> retrieveAllProducts(Pageable pageable);

    @GetMapping(path = "/{productId}")
    @ResponseStatus(HttpStatus.OK)
    Product retrieveProductById(@PathVariable Long productId);

    @GetMapping(path = "/product-identifier/{productIdentifier}")
    @ResponseStatus(HttpStatus.OK)
    Product retrieveProductByProductIdentifier(@PathVariable String productIdentifier);

    @GetMapping(path = "/category/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    Page<Product> retrieveProductByCategoryId(@PathVariable Long categoryId, Pageable pageable);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Product createProduct(@Valid @RequestBody Product product);

    @PutMapping(path = "/{productId}")
    @ResponseStatus(HttpStatus.CREATED)
    Product updateProduct(@RequestBody ProductBody productBody, @PathVariable Long productId);

    @DeleteMapping(path = "/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteProduct(@PathVariable Long productId);
}
