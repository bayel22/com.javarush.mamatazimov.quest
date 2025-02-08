package com.javarush.mamatazimov.quest.entity;

public class User {
    private String name;
    private int playCount;

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