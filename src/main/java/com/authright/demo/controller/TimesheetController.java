package com.authright.demo.controller;

import com.authright.demo.model.Contract;
import com.authright.demo.model.User;
import com.authright.demo.model.WeekTime;
import com.authright.demo.service.UserService;
import com.authright.demo.service.WeekTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController("/timesheet")
public class TimesheetController {

    @Autowired
    private WeekTimeService weekTimeService;

    @Autowired
    private UserService userService;

    @RequestMapping
    public List<WeekTime> initial(){
        User user = userService.getUserByUsername("liaoyu");
        List<WeekTime> weekTimeList = new ArrayList<>();
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        for(Contract contract : user.getContracts()){
            Date startDate = contract.getStartDate();
            Date cursor = new Date(startDate.getTime());
        }
        return weekTimeList;
    }

    @CrossOrigin
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
}
