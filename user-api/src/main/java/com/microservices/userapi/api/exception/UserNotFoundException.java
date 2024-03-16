package com.microservices.userapi.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserNotFoundException extends ResponseStatusException {

    private static final HttpStatus HTTP_STATUS = HttpStatus.UNAUTHORIZED;

    public UserNotFoundException(String userAttribute) {
        super(HTTP_STATUS, String.format("User with attribute %s not found", userAttribute));
    }
}
