package com.authright.demo.service;

import com.authright.demo.model.User;
import com.authright.demo.model.WeekTime;

import java.util.List;

public interface WeekTimeService {
    WeekTime updateWeektime(WeekTime weekTime);
    WeekTime submitWeektime(WeekTime weekTime);
    List<WeekTime> getUnsubmittedWeekTimeListByUser(User user);
    List<WeekTime> getSubmittedWeekTimeListByUser(User user);
    List<WeekTime> getWeekTimeListByUser(User user);
}
