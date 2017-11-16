package com.authright.demo.controller;

import com.authright.demo.model.ResponseTime;
import com.authright.demo.model.User;
import com.authright.demo.model.UserTime;
import com.authright.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class JsonController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addtimesheet", method = RequestMethod.POST)
    public ResponseTime update(@RequestBody UserTime userTime) {
        ResponseTime rt = new ResponseTime(userTime.getUserID(), "Success");
        return rt;
    }

    @RequestMapping("/app-logout")
    public String logout() {
        return "Successfully logged out!";
    }

    @RequestMapping("/")
    public String home(Principal principal) {
        User user = userService.getUserByUsername(principal.getName());
        return "Hello " + user.getFirstName() + " " + user.getLastName();
    }
}
