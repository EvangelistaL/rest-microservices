package com.microservices.shoppingclient.model;

import java.time.LocalDate;

public record User(Long id, String name, String cpf, String address, String email, String phone, LocalDate registrationDate) {
}
