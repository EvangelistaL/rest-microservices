package com.microservices.userapi.api.specification;

import com.microservices.userapi.internal.entity.QUser;
import com.querydsl.core.types.Predicate;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserSpecification {

    private static final QUser qUser = QUser.user;

    public static Predicate findById(Long id){
        return qUser.id.eq(id);
    }

    public static Predicate findByName(String name){
        return qUser.name.containsIgnoreCase(name);
    }

    public static Predicate findByCpf(String cpf){
        return qUser.cpf.eq(cpf);
    }
}
