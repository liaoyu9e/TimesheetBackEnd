package com.example.controller;

import com.example.entity.ResponseTime;
import com.example.entity.UserTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JsonController {
    @RequestMapping(value = "/addtimesheet", method = RequestMethod.POST)
    public ResponseEntity<ResponseTime> update(@RequestBody UserTime userTime){
        ResponseTime rt = new ResponseTime(userTime.getUserID(), "Success");
        return new ResponseEntity<ResponseTime>(rt, HttpStatus.OK);
    }
}
