package com.example.mockitotest;
import com.example.mockitotest.repo.UserRepoImpl;
import com.example.mockitotest.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static com.example.mockitotest.UserConstant.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserRepoTest {
private UserRepoImpl userRepo = new UserRepoImpl();

    @Test
    public void addNullUserList() {
        List<User> test = userRepo.getAllUsers();
        Assertions.assertEquals(NULL_LIST, test);
    }
    @Test
    public void correctUserListAdd(){
        userRepo.addUser(USER_1);
        userRepo.addUser(USER_2);
        userRepo.addUser(USER_3);
        userRepo.addUser(USER_4);
        List<User> expected = userRepo.getAllUsers();
        Assertions.assertEquals(expected,USER_LIST);
    }
    @Test
    public void findUserByLoginIfUserExist(){
        userRepo.addUser(USER_1);
        userRepo.addUser(USER_2);
        userRepo.addUser(USER_3);
        userRepo.addUser(USER_4);
        assertNotNull(userRepo);
        Optional<User> expected = userRepo.findByLogin(USER_1.getLogin());
        Assertions.assertEquals(expected,Optional.of(USER_1));
    }
    @Test
    public void findUserByLoginIfUserIsNotExist(){
        userRepo.addUser(USER_2);
        userRepo.addUser(USER_3);
        userRepo.addUser(USER_4);
        assertNotNull(userRepo);
        Optional<User> expected = userRepo.findByLogin(USER_1.getLogin());
        Assertions.assertNotEquals(expected,Optional.of(USER_1));
    }
    @Test
    public void findUserByLoginAndPasswordIfUserExist(){
        userRepo.addUser(USER_1);
        userRepo.addUser(USER_2);
        userRepo.addUser(USER_3);
        userRepo.addUser(USER_4);
        assertNotNull(userRepo);
        Optional<User> expected = userRepo.findByLoginPassword(USER_1.getLogin(),USER_1.getPassword());
        Assertions.assertEquals(expected,Optional.of(USER_1));
    }
    @Test
    public void findUserByCorrectLoginWrongPassword(){
        userRepo.addUser(USER_1);
        userRepo.addUser(USER_2);
        userRepo.addUser(USER_3);
        userRepo.addUser(USER_4);
        assertNotNull(userRepo);
        Optional<User> expected = userRepo.findByLoginPassword(USER_1.getLogin(),USER_2.getPassword());
        Assertions.assertNotEquals(expected,Optional.of(USER_1));
    }
    @Test
    public void findUserByWrongLoginCorrectPassword(){
        userRepo.addUser(USER_1);
        userRepo.addUser(USER_2);
        userRepo.addUser(USER_3);
        userRepo.addUser(USER_4);
        assertNotNull(userRepo);
        Optional<User> expected = userRepo.findByLoginPassword(USER_2.getLogin(),USER_1.getPassword());
        Assertions.assertNotEquals(expected,Optional.of(USER_1));
    }
}
