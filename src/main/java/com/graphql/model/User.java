package com.graphql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "_user")
public class User extends BaseEntity{
    private String name;
    private String surname;
    private String username;
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

}
