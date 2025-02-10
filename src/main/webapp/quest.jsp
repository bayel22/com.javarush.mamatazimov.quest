<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.javarush.mamatazimov.quest.entity.Question" %>
<%@ page import="java.util.List" %>
<%@ page import="com.javarush.mamatazimov.quest.repository.Repository" %>
<%@ page import="com.javarush.mamatazimov.quest.entity.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="с" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "КВЕСТ" %></h1>

<br>
    <div>
        <h3>Статистика</h3>
        <p>Имя: ${sessionScope.user}</p>
        <p>Побед: ${sessionScope.countWin}</p>
        <p>Проигрышей: ${sessionScope.countLoss}</p>
    </div>
<br>



    <h2>Вопрос</h2>
    <c:set var="questionVar" value="${sessionScope.question}"/>
    <h4>${questionVar}</h4>
<br>

    <h3>Ответы</h3>
<br>
<div>
    <form id="answersDiv" method="get">

    </form>
</div>
<c:set var="counterAnswer" value="${sessionScope.counterAnswer}"/>
<c:forEach var="i" begin="1" end="${counterAnswer}" >
    <c:set var="answerKey" value="answer_${i}"/>
    <c:set var="checkLossKey" value="checkLoss_${i}"/>
    <c:set var="checkAnswerWinKey" value="checkAnswerWin_${i}"/>
    <c:set var="checkLastAnswerKey" value="checkLastAnswer_${i}"/>
    <c:set var="answerText" value="${sessionScope[answerKey]}"/>
    <c:set var="checkLossValue" value="${sessionScope[checkLossKey]}"/>
    <c:set var="checkAnswerWinValue" value="${sessionScope[checkAnswerWinKey]}"/>
    <c:set var="checkLastAnswerValue" value="${sessionScope[checkLastAnswerKey]}"/>

    <form action="hello-servlet" method="post" style="display: inline;">
        <input type="hidden" name="checkLossValue" value="${checkLossValue}">
        <input type="hidden" name="questionID" value="${sessionScope.questionID}">
        <input type="hidden" name="checkAnswerWin" value="${checkAnswerWinValue}">
        <input type="hidden" name="checkLastAnswer" value="${checkLastAnswerValue}">
        <button type="submit">${answerText}</button>
    </form>

    </c:forEach>
<br>
<br>
    <button type="submit" onclick="window.location.href='index.jsp'">Меню</button>
</body>
</html>