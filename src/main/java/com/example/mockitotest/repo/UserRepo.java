package com.example.mockitotest.repo;

import com.example.mockitotest.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepo {
    public User addUser(User user);
    public Optional<User> findByLogin(String login);
    public Optional<User> findByLoginPassword(String login, String password);
    public List<User> getAllUsers();
}
