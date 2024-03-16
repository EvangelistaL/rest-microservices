package com.microservices.shoppingapi.api.specification;

import com.microservices.shoppingapi.internal.entity.QShop;
import com.querydsl.core.types.Predicate;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@UtilityClass
public class ShopSpecification {

    private static final QShop qShop = QShop.shop;

    public Predicate findAllByUserIdentifier(String userIdentifier){
        return qShop.userIdentifier.eq(userIdentifier);
    }

    public Predicate findAllByTotalGreaterThan(BigDecimal total){
        return qShop.total.gt(total);
    }

    public Predicate findAllByDateGreaterThan(LocalDateTime shopDate){
        return qShop.shopDate.gt(shopDate);
    }

    public Predicate findBetweenDates(LocalDate startDate, LocalDate finalDate){
        return qShop.shopDate.between(LocalDateTime.of(startDate, LocalTime.now()),
                LocalDateTime.of(finalDate, LocalTime.now()));
    }

    public Predicate findById(Long id){
        return qShop.id.eq(id);
    }
}
