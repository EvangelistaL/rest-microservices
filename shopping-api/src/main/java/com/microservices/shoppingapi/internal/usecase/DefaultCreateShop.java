package com.microservices.shoppingapi.internal.usecase;

import com.microservices.shoppingapi.api.usecase.CreateShop;
import com.microservices.shoppingapi.api.usecase.RetrieveProductByIdentifier;
import com.microservices.shoppingapi.api.usecase.RetrieveUser;
import com.microservices.shoppingapi.internal.entity.Item;
import com.microservices.shoppingapi.internal.entity.Shop;
import com.microservices.shoppingapi.internal.repository.ShopRepository;
import com.microservices.shoppingclient.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultCreateShop implements CreateShop {

    private final ShopRepository shopRepository;

    private final RetrieveUser retrieveUser;

    private final RetrieveProductByIdentifier retrieveProductByIdentifier;

    @Override
    public Shop execute(Shop shop) {
        this.retrieveUser.execute(shop.getUserIdentifier());
        validateProducts(shop.getItems());
        shop.setShopDate(LocalDateTime.now());
        calculatesTotalPurchaseValue(shop);
        return this.shopRepository.save(shop);
    }

    private void validateProducts(List<Item> items){
        for(Item item : items){
            Product product = this.retrieveProductByIdentifier.execute(item.getProductIdentifier());
            item.setPrice(product.price());
        }
    }

    private void calculatesTotalPurchaseValue(Shop shop){
        shop.setTotal(shop.getItems()
                .stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add));
    }

}
