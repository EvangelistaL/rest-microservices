package com.microservices.shoppingapi.internal.usecase;

import com.microservices.shoppingapi.api.usecase.RetrieveProductByIdentifier;
import com.microservices.shoppingclient.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DefaultRetrieveProductByIdentifier implements RetrieveProductByIdentifier {

    @Value("${product-api.base-url}")
    private String baseUrl;

    @Override
    public Product execute(String productIdentifier) {
        try{
            WebClient webClient = WebClient.builder()
                    .baseUrl(baseUrl)
                    .build();

            Mono<Product> product = webClient.get()
                    .uri(String.format("/product-identifier/%s", productIdentifier))
                    .retrieve()
                    .bodyToMono(Product.class);

            return product.block();
        } catch (ResponseStatusException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Product with identifier = %s not found", productIdentifier));
        }
    }
}
