package com.microservices.shoppingapi.internal.usecase;

import com.microservices.shoppingapi.api.model.ShopReport;
import com.microservices.shoppingapi.api.specification.ShopSpecification;
import com.microservices.shoppingapi.api.usecase.RetrieveAllShop;
import com.microservices.shoppingapi.api.usecase.RetrieveShopReport;
import com.microservices.shoppingapi.internal.entity.Shop;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomRetrieveShopReport implements RetrieveShopReport {

    private final RetrieveAllShop retrieveAllShop;

    @Override
    public ShopReport execute(LocalDate startDate, LocalDate finalDate) {
        List<Shop> shopsBetweenDates = this.retrieveAllShop.execute(ShopSpecification.findBetweenDates(startDate, finalDate), Pageable.unpaged())
                .stream()
                .toList();

        Integer count = countShops(shopsBetweenDates);
        BigDecimal sumShopTotal = sumShopTotal(shopsBetweenDates);

        return new ShopReport(count, sumShopTotal, shopTotalAvg(count, sumShopTotal));
    }

    private Integer countShops(List<Shop> shops){
        return shops.size();
    }

    private BigDecimal sumShopTotal(List<Shop> shops){
        return shops.stream()
                .map(Shop::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private double shopTotalAvg(Integer shopCount, BigDecimal shopTotal){
        return shopTotal.divide(BigDecimal.valueOf(shopCount), RoundingMode.UNNECESSARY).doubleValue();
    }
}
