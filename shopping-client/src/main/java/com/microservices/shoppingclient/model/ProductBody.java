package com.microservices.shoppingclient.model;

import java.math.BigDecimal;

public record ProductBody(String productIdentifier, String name, String description, BigDecimal price) {
}
