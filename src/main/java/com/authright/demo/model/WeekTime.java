package com.authright.demo.model;

public class WeekTime {
    private int Mon;
    private int Tue;

    public WeekTime(int mon, int tue) {
        Mon = mon;
        Tue = tue;
    }

    public WeekTime() {
    }

    public int getMon() {
        return Mon;
    }

    public void setMon(int mon) {
        Mon = mon;
    }

    public int getTue() {
        return Tue;
    }

    public void setTue(int tue) {
        Tue = tue;
    }
}
