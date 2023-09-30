package com.graphql.model;

import lombok.Data;

@Data
public class UserRequest {
    private String id;
    private String name;
    private String surname;
    private String username;
    private String email;
    private Role role;
}
