package com.example.mockitotest;

import com.example.mockitotest.models.User;
import com.example.mockitotest.repo.UserRepoImpl;

import static com.example.mockitotest.UserConstant.*;
import static java.lang.System.out;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.mockitotest.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    UserRepoImpl userRepoImpl;

    @InjectMocks
    UserService userService;

    @Test
    void whenUsersInRepositoryThenGetAllLoginsAsList(){
        when(userRepoImpl.getAllUsers())
                .thenReturn(USER_LIST);
        assertThat(userService.findAllLogins()).isEqualTo(USER_LOGIN);
    }
    @Test
    void whenUsersInRepositoryIsEmptyThenGetAllLoginsAsListIsEmpty(){
        when(userRepoImpl.getAllUsers())
                .thenReturn(List.of());
        assertThat(userService.findAllLogins()).isEqualTo(List.of());
    }
    @Test
    void whenUsersInRepositoryIsNullThenGetAllLoginsAsListIsNull(){
        when(userRepoImpl.getAllUsers())
                .thenReturn(null);
        assertThat(userService.findAllLogins()).isEqualTo(null);
    }
    @Test
    void whenCorrectUserIsAddedThenAddUserIsCalledFromRepo(){
        when(userRepoImpl.getAllUsers()).thenReturn(List.of());
        when(userRepoImpl.addUser(any(User.class))).thenReturn(null);
        userService.addUser("test","test1");
        verify(userRepoImpl).addUser(any());
    }

}
