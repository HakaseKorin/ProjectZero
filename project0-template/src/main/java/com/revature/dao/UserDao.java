package com.revature.dao;

import com.revature.models.User;

import java.util.List;

public interface UserDao {
    boolean createUser(User user);
    User getByEmailAndPassword(String email, String password);
    List<User> getAll();
    User getById(int id);
    boolean update(User updatedUser);
    boolean deleteById(int id);
}
