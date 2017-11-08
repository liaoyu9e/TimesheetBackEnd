package com.example.entity;

public class UserTime {
    private String userID;
    private WeekTime timesheet;

    public UserTime(String userID, WeekTime timesheet) {
        this.userID = userID;
        this.timesheet = timesheet;
    }

    public UserTime() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public WeekTime getTimesheet() {
        return timesheet;
    }

    public void setTimesheet(WeekTime timesheet) {
        this.timesheet = timesheet;
    }
}
