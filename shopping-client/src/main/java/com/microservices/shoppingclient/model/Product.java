package com.microservices.shoppingclient.model;

import java.math.BigDecimal;

public record Product(Long id, String productIdentifier, String name, String description, BigDecimal price,
                      Category category) {
}
