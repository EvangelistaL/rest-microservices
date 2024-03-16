package com.microservices.userapi.api.model;

public record UserUpdate(String name, String cpf, String address, String email, String phone) {
}
