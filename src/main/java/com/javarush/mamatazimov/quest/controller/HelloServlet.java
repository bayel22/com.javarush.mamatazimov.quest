package com.javarush.mamatazimov.quest.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.javarush.mamatazimov.quest.entity.Answer;
import com.javarush.mamatazimov.quest.entity.Question;
import com.javarush.mamatazimov.quest.entity.User;
import com.javarush.mamatazimov.quest.repository.Repository;
import com.javarush.mamatazimov.quest.service.Logic;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Logic.checkNullUser(request, session);
        if (request.getParameter("restartButton") != null) {
            session.invalidate();
            response.sendRedirect("login.jsp");
            return;
        }
        if (session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        String checkLossValue = request.getParameter("checkLossValue");
        String answerWinValue = request.getParameter("checkAnswerWin");
        session.setAttribute("checkLossValue", checkLossValue);
        session.setAttribute("checkAnswerWin", answerWinValue);
        if (Logic.checkWinOrLoss(checkLossValue,answerWinValue, session)) {
            session.setAttribute("counterQuestion", 0);
            response.sendRedirect("winOrLoss.jsp");
            return;
        }
        Logic.showQuestion(session);
        response.sendRedirect("quest.jsp");
    }
}