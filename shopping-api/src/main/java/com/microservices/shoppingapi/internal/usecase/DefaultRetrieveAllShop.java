package com.microservices.shoppingapi.internal.usecase;

import com.microservices.shoppingapi.api.usecase.RetrieveAllShop;
import com.microservices.shoppingapi.internal.entity.Shop;
import com.microservices.shoppingapi.internal.repository.ShopRepository;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultRetrieveAllShop implements RetrieveAllShop {

    private final ShopRepository shopRepository;

    @Override
    public Page<Shop> execute(Predicate predicate, Pageable pageable) {
        if (predicate == null){
            return this.shopRepository.findAll(pageable);
        }
        return this.shopRepository.findAll(predicate, pageable);
    }
}
