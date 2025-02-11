package com.javarush.mamatazimov.quest.repository;

import com.javarush.mamatazimov.quest.entity.Answer;
import com.javarush.mamatazimov.quest.entity.Question;
import com.javarush.mamatazimov.quest.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Repository {
    private static final List<Question> questions = new ArrayList<>(Arrays.asList(
            new Question("На борту твоего корабля загорается сигнал тревоги. Проверить?", 1),
            new Question("Ты обнаруживаешь, что это сигнал от НЛО. Они предлагают встретиться. Согласиться?", 2),
            new Question("Ты согласился на встречу. НЛО запрашивает доступ к твоему кораблю. Разрешить?", 3),
            new Question("Ты разрешил доступ. На мостик проникает голограмма капитана НЛО. Она говорит: 'Мы ищем Артефакт Созидания. Ты поможешь?'", 4),
            new Question("Ты согласился помочь. НЛО передает координаты древнего храма на заброшенной планете. Лететь туда?", 5),
            new Question("Ты прибыл на планету. Храм охраняют древние механизмы. Как поступить?", 6)
    ));

    private static final List<Answer> answers = new ArrayList<>(Arrays.asList(
            // Ответы к вопросу 1
            new Answer("Игнорировать сигнал", false, 11, true), // Игрок игнорирует сигнал, и история заканчивается
            new Answer("Проверить сигнал", false, 12), // Переход к вопросу 2

            // Ответы к вопросу 2
            new Answer("Отклонить предложение", false, 21, true), // Игрок отказывается, и история заканчивается
            new Answer("Согласиться на встречу", false, 22), // Переход к вопросу 3

            // Ответы к вопросу 3
            new Answer("Разрешить доступ", false, 31), // Переход к вопросу 4
            new Answer("Отказать в доступе", false, 32, true), // Игрок отказывает, и история заканчивается

            // Ответы к вопросу 4
            new Answer("Солгать, что не знаешь об артефакте", true, 41, true), // Игрок лжет, и история заканчивается
            new Answer("Согласиться помочь", false, 42), // Переход к вопросу 5

            // Ответы к вопросу 5
            new Answer("Лететь к храму", false, 51), // Переход к вопросу 6
            new Answer("Отказаться и вернуться домой", false, 52, true), // Игрок отказывается, и история заканчивается

            // Ответы к вопросу 6
            new Answer("Попытаться обойти механизмы", false, 61, false, true), // Игрок успешно обходит механизмы
            new Answer("Атаковать механизмы", false, 62, true) // Игрок атакует, но терпит поражение
    ));
    public List<Question> getQuestionsList() {
        return questions;
    }

    public List<Answer> getAnswersList() {
        return answers;
    }
}
