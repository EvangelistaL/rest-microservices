package com.microservices.productapi.internal.usecase;

import com.microservices.productapi.api.usecase.CreateProduct;
import com.microservices.productapi.internal.entity.Category;
import com.microservices.productapi.internal.entity.Product;
import com.microservices.productapi.internal.repository.CategoryRepository;
import com.microservices.productapi.internal.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultCreateProduct implements CreateProduct {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    @Override
    public Product execute(Product product) {
        this.saveCategory(product.getCategory());
        return this.productRepository.save(product);
    }

    private void saveCategory(Category category){
        if (category != null){
            this.categoryRepository.save(category);
        }
    }
}
