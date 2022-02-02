package com.revature.dao;

import com.revature.models.User;

import java.util.List;

public interface UserDao {
    boolean createUser(User user);
    User getByEmailAndPassword(String email, String password);
    List<User> getAll();
}
