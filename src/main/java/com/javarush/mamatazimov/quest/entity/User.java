package com.javarush.mamatazimov.quest.entity;

public class User {
    private final String name;
    private long countLoss = 0;
    private long countWin = 0;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public long getCountLoss() {
        return countLoss;
    }
    public long getCountWin() {
        return countWin;
    }
    public void setCountLoss(long countLoss) {
        this.countLoss = countLoss;
    }
    public void setCountWin(long countWin) {
        this.countWin = countWin;
    }
}