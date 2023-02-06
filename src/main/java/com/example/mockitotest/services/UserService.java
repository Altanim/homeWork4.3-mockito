package com.example.mockitotest.services;

import com.example.mockitotest.models.User;
import com.example.mockitotest.repo.UserRepoImpl;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private final UserRepoImpl userRepoImpl;

    public UserService(UserRepoImpl userRepoImpl) {
        this.userRepoImpl = userRepoImpl;
    }
    public void addUser(String login, String password) {
        User user = new User(login,password);
        if (login == null || login.isBlank()){
            throw new IllegalArgumentException("Login is empty");
        }
        if (password == null || password.isBlank()){
            throw new IllegalArgumentException("Password is empty");
        }
        boolean userExist = this.userRepoImpl
                .getAllUsers()
                .stream()
                .anyMatch(u -> u.equals(user));
        if (userExist) {
            throw new IllegalArgumentException("User already exist");
        }
        this.userRepoImpl.addUser(user);
    }
    public List<String> findAllLogins(){
        Collection<User> users = this.userRepoImpl.getAllUsers();
        if (users == null){
            return null;
        }
        return users
                .stream()
                .map(User::getLogin)
                .collect(Collectors.toList());

    }


}
