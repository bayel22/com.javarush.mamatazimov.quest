package com.javarush.mamatazimov.quest.entity;

public class User {
    private String name;
    private int playCount;
    private long countLoss;
    private long countWin;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}