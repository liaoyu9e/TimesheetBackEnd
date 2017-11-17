package com.authright.demo.controller;

import com.authright.demo.model.Contract;
import com.authright.demo.model.User;
import com.authright.demo.model.WeekTime;
import com.authright.demo.service.UserService;
import com.authright.demo.service.WeekTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController("/timesheet")
public class TimesheetController {

    @Autowired
    private WeekTimeService weekTimeService;

    @Autowired
    private UserService userService;

    @RequestMapping
    public List<WeekTime> initial(Principal principal){
        User user = userService.getUserByUsername(principal.getName());
        List<WeekTime> weekTimeList = new ArrayList<>();
        Date today = new Date();
        for(Contract contract : user.getContracts()){
            Date startDate = contract.getStartDate();
        }
        return weekTimeList;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public WeekTime updateWeekTime(@RequestBody WeekTime weekTime){
        weekTimeService.updateWeektime(weekTime);
        return weekTime;
    }
}
