package com.microservices.shoppingapi.api.usecase;

import com.microservices.shoppingclient.model.User;

public interface RetrieveUser {

    User execute(String cpf);
}
