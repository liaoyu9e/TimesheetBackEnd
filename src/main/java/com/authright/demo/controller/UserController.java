package com.authright.demo.controller;

import com.authright.demo.model.User;
import com.authright.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @RequestMapping("/{username}")
    @PreAuthorize("hasRole('ROLE_MANAGER') OR hasRole('ROLE_ADMIN')")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_MANAGER') OR hasRole('ROLE_ADMIN')")
    public String deleteUserByUsername(@RequestBody String username) {
        User user = userService.getUserByUsername(username);
        if (user == null) return "Cannot find username " + username;
        userService.deleteUser(user);
        return "Successfully deleted " + username;
    }
}
