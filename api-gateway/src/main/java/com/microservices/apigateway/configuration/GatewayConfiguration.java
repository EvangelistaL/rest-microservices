package com.microservices.apigateway.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Value("${user-api.base-url}")
    private String userApiUrl;

    @Value("${product-api.base-url}")
    private String productApiUrl;

    @Value("${shopping-api.base-url}")
    private String shoppingApiUrl;

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route("user_route", route -> route.path("/users/**")
                        .uri(userApiUrl))
                .route("product_route", route -> route.path("/products/**")
                        .uri(productApiUrl))
                .route("shopping_route", route -> route.path("/shopping/**")
                        .uri(shoppingApiUrl))
                .build();
    }
}
