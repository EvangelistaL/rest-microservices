package com.microservices.shoppingapi.api.usecase;

import com.microservices.shoppingapi.internal.entity.Shop;

public interface CreateShop {

    Shop execute(Shop shop);
}
