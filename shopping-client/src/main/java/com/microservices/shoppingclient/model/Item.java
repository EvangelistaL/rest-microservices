package com.microservices.shoppingclient.model;

import java.math.BigDecimal;

public record Item(Long id, String productIdentifier, BigDecimal price) {
}
