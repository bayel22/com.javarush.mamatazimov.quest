<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Результат</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        .result-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            text-align: center;
        }
        .result-message {
            font-size: 2rem;
            margin-bottom: 20px;
        }
        .btn-custom {
            margin-top: 20px;
            padding: 10px 30px;
            font-size: 1.2rem;
        }
    </style>
</head>
<body>
<div class="result-container">
    <c:choose>
        <c:when test="${sessionScope.checkLossValue == true}">
            <h2 class="result-message text-danger">Вы проиграли 😔</h2>
            <button type="button" class="btn btn-primary btn-custom" onclick="window.location.href='index.jsp'">Меню</button>
        </c:when>
        <c:when test="${sessionScope.checkAnswerWin == true}">
            <h2 class="result-message text-success">Вы победили 🏆</h2>
            <button type="button" class="btn btn-primary btn-custom" onclick="window.location.href='index.jsp'">Меню</button>
        </c:when>
    </c:choose>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
