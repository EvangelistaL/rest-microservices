package com.microservices.productapi.api.specification;

import com.microservices.productapi.internal.entity.QProduct;
import com.querydsl.core.types.Predicate;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductSpecification {

    private static final QProduct qProduct = QProduct.product;

    public static Predicate findByCategory(Long categoryId){
        return qProduct.category.id.eq(categoryId);
    }

    public static Predicate findByProductIdentifier(String productIdentifier){
        return qProduct.productIdentifier.eq(productIdentifier);
    }

    public static Predicate findProductById(Long productId){
        return qProduct.id.eq(productId);
    }
}
