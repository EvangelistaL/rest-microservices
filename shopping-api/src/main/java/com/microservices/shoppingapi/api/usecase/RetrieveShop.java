package com.microservices.shoppingapi.api.usecase;

import com.microservices.shoppingapi.internal.entity.Shop;
import com.querydsl.core.types.Predicate;

public interface RetrieveShop {

    Shop execute(Predicate predicate);
}
