package com.javarush.mamatazimov.quest.entity;

public class Question {
    private String question;
    private long questionID;

    public Question(String question, long questionID) {
        this.question = question;
        this.questionID = questionID;
    }
    public String getText() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public long getID() {
        return questionID;
    }
    public void setQuestionId(long questionID) {
        this.questionID = questionID;
    }
}
