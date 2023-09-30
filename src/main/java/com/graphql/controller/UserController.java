package com.graphql.controller;

import com.graphql.model.User;
import com.graphql.model.UserRequest;
import com.graphql.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @QueryMapping
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @QueryMapping
    User getUserById(@Argument String id) {
        return userService.getUserById(id);
    }

    @MutationMapping
    User createUser(@Argument UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @MutationMapping
    User updateUser(@Argument UserRequest userRequest) {
        return userService.updateUser(userRequest);
    }

    @MutationMapping
    Boolean deleteUser(@Argument String id) {
        return userService.deleteUser(id);
    }
}
