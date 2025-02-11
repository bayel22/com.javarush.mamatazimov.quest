package com.javarush.mamatazimov.quest.service;

import com.javarush.mamatazimov.quest.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LogicTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpSession session;


    @Test
    void checkNullUser_UserNotInSession() {
        when(session.getAttribute("user")).thenReturn(null);
        when(request.getParameter("username")).thenReturn("testUser");
        Logic.checkNullUser(request, session);
        verify(session).setAttribute(eq("user"), eq("testUser"));
        verify(session).setAttribute(eq("userObject"), any(User.class));
    }

    @Test
    void checkNullUser_CreatesNewUserInSession() {
        when(session.getAttribute("user")).thenReturn("existingUser");
        Logic.checkNullUser(request, session);
        verify(session, never()).setAttribute(eq("userObject"), any(User.class));
        verify(session, never()).setAttribute(eq("user"), anyString());
    }

    @Test
    void showQuestion_ShowsQuestionAndAnswersInSession() {
        when(session.getAttribute("counterQuestion")).thenReturn(null);
        Logic.showQuestion(session);
        verify(session).setAttribute(eq("question"), anyString());
        verify(session).setAttribute(eq("questionID"), anyLong());
        verify(session).setAttribute(eq("counterQuestion"), eq(1));
        verify(session, atLeastOnce()).setAttribute(startsWith("answer_"), anyString());
        verify(session, atLeastOnce()).setAttribute(startsWith("checkLoss_"), anyBoolean());
        verify(session, atLeastOnce()).setAttribute(startsWith("checkAnswerWin_"), anyBoolean());
        verify(session, atLeastOnce()).setAttribute(startsWith("checkLastAnswer_"), anyBoolean());
    }

    @Test
    void checkWinOrLoss_ProcessingDefeat() {
        when(session.getAttribute("countWin")).thenReturn(null);
        when(session.getAttribute("countLoss")).thenReturn(null);
        User user = new User("testUser");
        when(session.getAttribute("userObject")).thenReturn(user);
        boolean result = Logic.checkWinOrLoss("true", "false", session);
        assertTrue(result);
        verify(session).setAttribute(eq("countLoss"), eq(1L));
        assertEquals(1, user.getCountLoss());
    }

    @Test
    void checkWinOrLoss_ProcessingVictory() {
        when(session.getAttribute("countWin")).thenReturn(null);
        when(session.getAttribute("countLoss")).thenReturn(null);
        User user = new User("testUser");
        when(session.getAttribute("userObject")).thenReturn(user);
        boolean result = Logic.checkWinOrLoss("false", "true", session);
        assertTrue(result);
        verify(session).setAttribute(eq("countWin"), eq(1L));
        assertEquals(1, user.getCountWin());
    }

    @Test void checkWinOrLoss_NoLossNoWin() {
        when(session.getAttribute("countWin")).thenReturn(null);
        when(session.getAttribute("countLoss")).thenReturn(null);
        User user = new User("testUser");
        when(session.getAttribute("userObject")).thenReturn(user);
        boolean result = Logic.checkWinOrLoss("false", "false", session);
        assertFalse(result);
        verify(session, never()).setAttribute(eq("countWin"), anyLong());
        verify(session, never()).setAttribute(eq("countLoss"), anyLong());
    }
}