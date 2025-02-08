package com.javarush.mamatazimov.quest.entity;

public class Answer {
    private String answer;
    private long questionId;

    public Answer(String answer, long questionId) {
        this.answer = answer;
        this.questionId = questionId;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public long getQuestionId() {
        return questionId;
    }
    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }
}
