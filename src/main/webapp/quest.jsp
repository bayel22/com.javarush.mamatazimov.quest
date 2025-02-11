<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Квест</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .answer-button {
            transition: transform 0.2s;
            text-align: left;
        }
        .answer-button:hover {
            transform: translateX(8px);
        }
        .statistics-card {
            height: 100vh;
            position: sticky;
            top: 0;
        }
    </style>
</head>
<body class="bg-light">
<div class="container-fluid">
    <div class="row g-0">
        <c:if test="${not empty sessionScope.user}">
            <div class="col-md-3 col-lg-2 bg-white shadow-sm statistics-card">
                <div class="p-3">
                    <h3 class="h5 mb-4">Ваша статистика</h3>
                    <div class="card mb-3 shadow-sm">
                        <div class="card-body">
                            <p class="mb-1"><strong>Имя:</strong> ${sessionScope.user}</p>
                        </div>
                    </div>
                    <div class="card mb-3 shadow-sm">
                        <div class="card-body">
                            <p class="mb-1"><strong>Побед:</strong> ${sessionScope.countWin}</p>
                        </div>
                    </div>
                    <div class="card shadow-sm">
                        <div class="card-body">
                            <p class="mb-1"><strong>Проигрышей:</strong> ${sessionScope.countLoss}</p>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
        <div class="col-md-9 col-lg-10 p-4">
            <div class="card shadow mb-4">
                <div class="card-body">
                    <h2 class="card-title h4 mb-3">Вопрос</h2>
                    <div class="alert alert-info mb-0">
                        <h4 class="m-0">${sessionScope.question}</h4>
                    </div>
                </div>
            </div>
            <div class="card shadow">
                <div class="card-body">
                    <h3 class="h5 mb-4">Ответы</h3>
                    <div class="d-grid gap-2">
                        <c:set var="counterAnswer" value="${sessionScope.counterAnswer}"/>
                        <c:forEach var="i" begin="1" end="${counterAnswer}">
                            <c:set var="answerKey" value="answer_${i}"/>
                            <c:set var="checkLossKey" value="checkLoss_${i}"/>
                            <c:set var="checkAnswerWinKey" value="checkAnswerWin_${i}"/>
                            <c:set var="checkLastAnswerKey" value="checkLastAnswer_${i}"/>
                            <form action="hello-servlet" method="post">
                                <input type="hidden" name="checkLossValue" value="${sessionScope[checkLossKey]}">
                                <input type="hidden" name="questionID" value="${sessionScope.questionID}">
                                <input type="hidden" name="checkAnswerWin" value="${sessionScope[checkAnswerWinKey]}">
                                <input type="hidden" name="checkLastAnswer" value="${sessionScope[checkLastAnswerKey]}">
                                <button type="submit" class="btn btn-primary answer-button">
                                        ${sessionScope[answerKey]}
                                </button>
                            </form>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
