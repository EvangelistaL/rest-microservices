package com.microservices.shoppingclient.model;

import java.math.BigDecimal;

public record ShopReport(Integer count, BigDecimal total, Double average) {
}
