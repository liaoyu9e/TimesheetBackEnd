package com.authright.demo.service;

import com.authright.demo.model.User;

public interface UserService {
    User createUser(User user);

    User getUserByUsername(String username);

    void deleteUser (User user);
}
