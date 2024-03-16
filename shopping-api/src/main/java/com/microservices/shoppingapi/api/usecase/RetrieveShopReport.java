package com.microservices.shoppingapi.api.usecase;

import com.microservices.shoppingapi.api.model.ShopReport;

import java.time.LocalDate;

public interface RetrieveShopReport {

    ShopReport execute(LocalDate startDate, LocalDate finalDate);
}
