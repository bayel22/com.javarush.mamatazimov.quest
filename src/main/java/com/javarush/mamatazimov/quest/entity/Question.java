package com.javarush.mamatazimov.quest.entity;

public class Question {
    private final String question;
    private final long questionID;

    public Question(String question, long questionID) {
        this.question = question;
        this.questionID = questionID;
    }
    public String getText() {
        return question;
    }
    public long getID() {
        return questionID;
    }
}
