package com.authright.demo.controller;

import com.authright.demo.entity.WeekTime;
import com.authright.demo.service.UserService;
import com.authright.demo.service.WeekTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


//timesheet request handler
@RestController("/timesheet")
public class TimesheetController {

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
}
