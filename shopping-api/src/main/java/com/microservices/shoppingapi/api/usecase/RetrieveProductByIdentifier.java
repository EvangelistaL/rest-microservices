package com.microservices.shoppingapi.api.usecase;

import com.microservices.shoppingclient.model.Product;

public interface RetrieveProductByIdentifier {

    Product execute(String productIdentifier);
}
