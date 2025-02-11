package com.javarush.mamatazimov.quest.service;

import com.javarush.mamatazimov.quest.entity.Answer;
import com.javarush.mamatazimov.quest.entity.Question;
import com.javarush.mamatazimov.quest.entity.User;
import com.javarush.mamatazimov.quest.repository.Repository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;

public class Logic {
    private static final Repository repository = new Repository();
    private static final List<Question> questionsList = repository.getQuestionsList();
    private static final List<Answer> answersList = repository.getAnswersList();

    public static void checkNullUser(HttpServletRequest req, HttpSession session) {
        if (session.getAttribute("user") == null) {
            User user = new User(req.getParameter("username"));
            session.setAttribute("userObject", user);
            session.setAttribute("user", user.getName());
        }
    }

    public static void showQuestion(HttpSession session) {
        Integer counterQuestion = (Integer) session.getAttribute("counterQuestion");
        int counterAnswer = 0;

        if (counterQuestion == null) {
            counterQuestion = 0;
        }

        if (counterQuestion < questionsList.size()) {
            Question question = questionsList.get(counterQuestion);
            session.setAttribute("question", question.getText());
            session.setAttribute("questionID", question.getID());
            session.setAttribute("counterQuestion", counterQuestion+1);

            for (Answer answer : answersList) {
                String answerFirstID = String.valueOf(answer.getID()).substring(0, 1);
                String answerLastID = String.valueOf(answer.getID()).substring(1, 2);
                if (answerFirstID.equals(String.valueOf(question.getID()))) {
                    session.setAttribute("answer_" + answerLastID, answer.getText());
                    session.setAttribute("checkLoss_" + answerLastID, answer.isLoss());
                    session.setAttribute("checkAnswerWin_" + answerLastID, answer.isWin());
                    session.setAttribute("checkLastAnswer_" + answerLastID, answer.isLastAnswer());
                    counterAnswer++;
                }
            }
        }
        session.setAttribute("counterAnswer", counterAnswer);
    }

    public static boolean checkWinOrLoss(String checkLossValue, String checkWinValue,HttpSession session) {
        if (session.getAttribute("countLoss") == null) {
            session.setAttribute("countLoss", 0);
        }
        if (session.getAttribute("countWin") == null) {
            session.setAttribute("countWin", 0);
        }

        User user = (User) session.getAttribute("userObject");

        long countLoss =  user.getCountLoss();
        long countWin = user.getCountWin();

        if (checkLossValue == null || checkWinValue == null) {
            return false;
        }
        if (Boolean.parseBoolean(checkLossValue)) {
            countLoss++;
            user.setCountLoss(countLoss);
            session.setAttribute("countLoss", user.getCountLoss());
            return true;
        }
        if (Boolean.parseBoolean(checkWinValue)) {
            countWin++;
            user.setCountWin(countWin);
            session.setAttribute("countWin", user.getCountWin());
            return true;
        }
        return false;
    }
}
