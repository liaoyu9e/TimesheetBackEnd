package com.authright.demo.service;

import com.authright.demo.entity.User;

public interface UserService {
    User createUser(User user);

    User getUserByUsername(String username);

    void deleteUser (User user);
}
