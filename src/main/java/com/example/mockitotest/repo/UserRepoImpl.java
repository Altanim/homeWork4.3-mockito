package com.example.mockitotest.repo;

import com.example.mockitotest.models.User;

import java.util.*;

public class UserRepoImpl implements UserRepo {
    private final List<User> users = new ArrayList<>();

    public User addUser(User user){
        this.users.add(user);
        return user;
    }
    public Optional<User> findByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
    public Optional<User> findByLoginPassword(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
    public List<User> getAllUsers(){
        return new ArrayList<User>(users);
    }
}
