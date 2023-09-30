package com.graphql.service;

import com.graphql.model.User;
import com.graphql.model.UserRequest;
import com.graphql.repostory.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(String id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
    }

    public User createUser(UserRequest userRequest) {
        User user=User.builder()
                .username(userRequest.getUsername())
                .name(userRequest.getName())
                .surname(userRequest.getSurname())
                .email(userRequest.getEmail())
                .role(userRequest.getRole())
                .build();
        return repository.save(user);
    }

    public User updateUser(UserRequest userRequest) {
        User existing=getUserById(userRequest.getId());
        existing.setRole(userRequest.getRole());
        existing.setUsername(userRequest.getUsername());
        existing.setName(userRequest.getName());
        existing.setSurname(userRequest.getSurname());
        existing.setEmail(userRequest.getEmail());
        return repository.save(existing);
    }

    public boolean deleteUser(String id) {
        User existing=getUserById(id);
        repository.delete(existing);
        return true;
    }
}
