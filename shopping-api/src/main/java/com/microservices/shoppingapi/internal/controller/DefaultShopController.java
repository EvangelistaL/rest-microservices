package com.microservices.shoppingapi.internal.controller;

import com.microservices.shoppingapi.api.controller.ShopController;
import com.microservices.shoppingapi.api.model.ShopReport;
import com.microservices.shoppingapi.api.specification.ShopSpecification;
import com.microservices.shoppingapi.api.usecase.CreateShop;
import com.microservices.shoppingapi.api.usecase.RetrieveAllShop;
import com.microservices.shoppingapi.api.usecase.RetrieveShop;
import com.microservices.shoppingapi.api.usecase.RetrieveShopReport;
import com.microservices.shoppingapi.internal.entity.Shop;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@ConditionalOnSingleCandidate(ShopController.class)
public class DefaultShopController implements ShopController {

    private final CreateShop createShop;

    private final RetrieveAllShop retrieveAllShop;

    private final RetrieveShop retrieveShop;

    private final RetrieveShopReport retrieveShopReport;

    @Override
    public Page<Shop> retrieveAllShop(Pageable pageable) {
        return this.retrieveAllShop.execute(null, pageable);
    }

    @Override
    public Page<Shop> retrieveByUserIdentifier(String userIdentifier, Pageable pageable) {
        return this.retrieveAllShop.execute(ShopSpecification.findAllByUserIdentifier(userIdentifier), pageable);
    }

    @Override
    public Shop retrieveById(Long id) {
        return this.retrieveShop.execute(ShopSpecification.findById(id));
    }

    @Override
    public Shop createUser(Shop shop) {
        return this.createShop.execute(shop);
    }

    @Override
    public ShopReport retrieveShopReport(LocalDate startDate, LocalDate finalDate) {
        return this.retrieveShopReport.execute(startDate, finalDate);
    }


}
