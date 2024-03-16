package com.microservices.userapi.api.controller;

import com.microservices.userapi.api.model.UserUpdate;
import com.microservices.userapi.internal.entity.User;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public interface UserController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    User createUser(@Valid @RequestBody User user);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Page<User> retrieveAllUsers(Pageable pageable);

    @GetMapping(path = "/{userId}")
    @ResponseStatus(HttpStatus.OK)
    User retrieveUserById(@PathVariable Long userId);

    @GetMapping(path = "/user-name/{userName}")
    @ResponseStatus(HttpStatus.OK)
    Page<User> retrieveUsersByName(@PathVariable String userName, Pageable pageable);

    @GetMapping(path = "/{cpf}/cpf")
    @ResponseStatus(HttpStatus.OK)
    User retrieveUserByCpf(@PathVariable String cpf);

    @PutMapping(path = "/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    User updateUser(@RequestBody UserUpdate userUpdate, @PathVariable Long userId);

    @DeleteMapping(path = "/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteUser(@PathVariable Long userId);

}
