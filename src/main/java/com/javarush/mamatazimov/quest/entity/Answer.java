package com.javarush.mamatazimov.quest.entity;

public class Answer {
    private final String answer;
    private final long answerID;
    private boolean loss = false;
    private boolean win = false;
    private boolean lastAnswer = false;

    public String getText() {
        return answer;
    }
    public long getID() {
        return answerID;
    }
    public boolean isLoss() {return loss;}

    public Answer(String answer, boolean lastAnswer, long answerID) {
        this.answer = answer;
        this.answerID = answerID;
        this.lastAnswer = lastAnswer;
    }

    //Создает новый объект Answer с указанием, является ли ответ проигрышным(параметр: loss).
    public Answer(String answer,boolean lastAnswer, long answerID, boolean loss) {
        this.answer = answer;
        this.answerID = answerID;
        this.loss = loss;
        this.lastAnswer = lastAnswer;
    }

    public Answer(String answer,boolean lastAnswer, long answerID, boolean loss, boolean win) {
        this.answer = answer;
        this.answerID = answerID;
        this.loss = loss;
        this.win = win;
        this.lastAnswer = lastAnswer;
    }

    public boolean isWin() {
        return win;
    }

    public boolean isLastAnswer() {
        return lastAnswer;
    }
}
