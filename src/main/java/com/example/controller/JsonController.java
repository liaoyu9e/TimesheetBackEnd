package com.example.controller;

import com.example.entity.ResponseTime;
import com.example.entity.UserTime;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JsonController {
    @RequestMapping(value = "/addtimesheet", method = RequestMethod.POST)
    public ResponseTime update(@RequestBody UserTime userTime){
        ResponseTime rt = new ResponseTime(userTime.getUserID(), "Success");
        return rt;
    }
}
