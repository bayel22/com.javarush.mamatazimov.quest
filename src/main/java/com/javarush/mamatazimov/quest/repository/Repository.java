package com.javarush.mamatazimov.quest.repository;

import com.javarush.mamatazimov.quest.entity.Answer;
import com.javarush.mamatazimov.quest.entity.Question;
import com.javarush.mamatazimov.quest.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Repository {
    private static final List<Question> questions = new ArrayList<>(Arrays.asList(
            new Question("Ты потерял память. Принять вызов НЛО?", 1),
            new Question("Ты принял вызов. Поднимаешься на мостик к капитану?", 2),
            new Question("Ты поднялся на мостик. Ты кто?", 3)
    ));

    private static final List<Answer> answers = new ArrayList<>(Arrays.asList(
            new Answer("Отклонить вызов", false,11,true),
            new Answer("Принять вызов",false, 12),
            new Answer("Подняться на мостик", false, 21),
            new Answer("Отказаться подниматься на мостик", false, 22, true),
            new Answer("Солгать о себе", true,31, true),
            new Answer("Рассказать правду о себе", false, 32, false, true)
    ));

    public List<Question> getQuestionsList() {
        return questions;
    }

    public List<Answer> getAnswersList() {
        return answers;
    }

    public static int questionsCount() {
        return questions.size();
    }

    public Question getQuestion(int questionId) {
        return questions.get(questionId);
    }

    public static int answersCount() {
        return answers.size();
    }

    public Answer getAnswer(int answerId) {
        return answers.get(answerId);
    }
}
