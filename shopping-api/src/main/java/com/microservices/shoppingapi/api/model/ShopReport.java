package com.microservices.shoppingapi.api.model;

import java.math.BigDecimal;

public record ShopReport(Integer count, BigDecimal total, Double average) {
}
