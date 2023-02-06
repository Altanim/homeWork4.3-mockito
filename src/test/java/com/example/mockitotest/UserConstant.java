package com.example.mockitotest;

import com.example.mockitotest.models.User;

import java.util.List;

public class UserConstant {
    public static final User USER_NULL = new User(null,null);
    public static final User USER_EMPTY = new User("","");
    public static final User USER_1 = new User("Potter", "dobby");
    public static final User USER_2 = new User("Spiderman", "goblin");
    public static final User USER_3 = new User("Thor", "tor123");
    public static final User USER_4 = new User("Frodo", "gendalf123");

    public static final List<User> NULL_LIST = List.of();

    public static final List<User> USER_LIST = List.of(
                USER_1,
                USER_2,
                USER_3,
                USER_4
        );
    public static final List<String> USER_LOGIN = List.of(
            USER_1.getLogin(),
            USER_2.getLogin(),
            USER_3.getLogin(),
            USER_4.getLogin()
    );
    }
