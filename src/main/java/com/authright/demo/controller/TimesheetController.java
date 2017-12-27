package com.authright.demo.controller;

import com.authright.demo.entity.Contract;
import com.authright.demo.entity.User;
import com.authright.demo.entity.WeekTime;
import com.authright.demo.security.auth.JwtAuthenticationToken;
import com.authright.demo.security.model.UserContext;
import com.authright.demo.service.ContractService;
import com.authright.demo.service.UserService;
import com.authright.demo.service.WeekTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


//timesheet request handler
@RestController
@RequestMapping("/api/timesheet")
public class TimesheetController {

    @Autowired
    private ContractService contractService;

    @Autowired
    private WeekTimeService weekTimeService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public WeekTime updateWeekTime(@RequestBody WeekTime weekTime){
        weekTimeService.updateWeektime(weekTime);
        return weekTime;
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public WeekTime submitWeekTime(@RequestBody WeekTime weekTime){
        weekTimeService.submitWeektime(weekTime);
        return weekTime;
    }

//    @RequestMapping("/getContractSet")
//    public Set<Contract> getContractSet(){
//        JwtAuthenticationToken auth = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.getUserByUsername(((UserContext) auth.getPrincipal()).getUsername());
//        return contractService.getContractSetByUser(user);
//    }

    @RequestMapping("/fetchTimesheetInfo")
    public Map<String, Set> fetchTimesheetInfo(){
        JwtAuthenticationToken auth = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByUsername(((UserContext) auth.getPrincipal()).getUsername());
        Map<String, Set> map = new HashMap<String, Set>();
        map.put("contracts", contractService.getContractSetByUser(user));
        map.put("weekTimes", weekTimeService.getWeekTimeSetByUser(user));
        return map;
    }
}
