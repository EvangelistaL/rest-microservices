package com.microservices.userapi.api.usecase;

import com.microservices.userapi.internal.entity.User;

public interface CreateUser {

    User execute(User user);
}
