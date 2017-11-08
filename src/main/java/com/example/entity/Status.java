package com.example.entity;

public enum Status{
    SUCCESS("Success"),FAILED("Failed");
    private String value;

    Status(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return  value;
    }
}