package com.revature.service;

import com.revature.models.Customer;
import com.revature.models.User;
import com.revature.models.UserType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void createUser() {
        UserService userService = new UserService();
        User user = new Customer();
        user.setEmail("JaneDoe@Email.com");
        user.setPassword("password2");
        user.setFirst("Jane");
        user.setLast("Doe");
        user.setType(UserType.CUSTOMER);

        userService.createUser(user);

    }

    @Test
    void getAll() {
    }

    @Test
    void getByUserAndPass() {
    }

    @Test
    void getById() {
    }

    @Test
    void update() {
    }
}