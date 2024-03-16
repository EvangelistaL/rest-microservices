package com.microservices.shoppingclient.model;

public record UserUpdate(String name, String cpf, String address, String email, String phone) {
}
