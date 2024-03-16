package com.microservices.shoppingapi.api.controller;

import com.microservices.shoppingapi.api.model.ShopReport;
import com.microservices.shoppingapi.internal.entity.Shop;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/shopping")
public interface ShopController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Page<Shop> retrieveAllShop(Pageable pageable);

    @GetMapping(path = "/user-identifier/{userIdentifier}")
    @ResponseStatus(HttpStatus.OK)
    Page<Shop> retrieveByUserIdentifier(@PathVariable String userIdentifier, Pageable pageable);

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    Shop retrieveById(@PathVariable Long id);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Shop createUser(@Valid @RequestBody Shop shop);

    @GetMapping("/shop-report")
    @ResponseStatus(HttpStatus.OK)
    ShopReport retrieveShopReport(@RequestParam LocalDate startDate, @RequestParam LocalDate finalDate);
}
