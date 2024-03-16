package com.microservices.shoppingapi.internal.usecase;

import com.microservices.shoppingapi.api.usecase.RetrieveShop;
import com.microservices.shoppingapi.internal.entity.Shop;
import com.microservices.shoppingapi.internal.repository.ShopRepository;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class DefaultRetrieveShop implements RetrieveShop {

    private final ShopRepository shopRepository;

    @Override
    public Shop execute(Predicate predicate) {
        return this.shopRepository.findOne(predicate)
                .stream()
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
