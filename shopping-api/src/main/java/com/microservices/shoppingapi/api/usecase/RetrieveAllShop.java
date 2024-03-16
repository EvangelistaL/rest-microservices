package com.microservices.shoppingapi.api.usecase;

import com.microservices.shoppingapi.internal.entity.Shop;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RetrieveAllShop {

    Page<Shop> execute(Predicate predicate, Pageable pageable);
}
