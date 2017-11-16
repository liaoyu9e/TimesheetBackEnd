package com.authright.demo.model;

public class ResponseTime {
    private String userID;
    private String status;

    public ResponseTime(String userID, String status) {
        this.userID = userID;
        this.status = status;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

