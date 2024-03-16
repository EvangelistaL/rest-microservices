package com.microservices.shoppingclient.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record Shop(Long id, String userIdentifier, LocalDateTime shopDate, BigDecimal total, List<Item> items) {
}
