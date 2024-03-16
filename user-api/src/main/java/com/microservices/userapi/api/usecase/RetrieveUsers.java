package com.microservices.userapi.api.usecase;

import com.microservices.userapi.internal.entity.User;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RetrieveUsers {

    Page<User> execute(Predicate predicate, Pageable pageable);
}
