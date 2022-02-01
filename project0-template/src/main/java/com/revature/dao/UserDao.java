package com.revature.dao;

import com.revature.models.User;

public interface UserDao {
    User getUserByEmailAndPassword(String email, String password);
}
