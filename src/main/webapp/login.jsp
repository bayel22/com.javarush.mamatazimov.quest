<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Авторизация</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="d-flex align-items-center justify-content-center">
<div class="container p-4 bg-white rounded shadow-lg" style="max-width: 500px;">
    <h2 class="text-center mb-4">Знакомство</h2>
    <div class="mb-4">
        <p>Когда ты поднялся на борт корабля, тебя поприветствовала девушка с черной папкой в руках:</p>
        <p>– Здравствуйте, командир!</p>
        <p>Я Зинаида – ваша помощница.</p>
        <p>Видите? Там в углу пьет кофе наш штурман – сержант Перегарный Серж.</p>
        <p>Под штурвалом спит наш бортмеханик – Черный Богдан.</p>
        <p><strong>А как обращаться к вам?</strong></p>
    </div>
    <form action="hello-servlet" method="post">
        <div class="mb-3">
            <label for="userName" class="form-label">Введите имя</label>
            <input type="text" class="form-control" id="userName" placeholder="Ваше имя" required name="username">
        </div>
        <button type="submit" class="btn btn-primary w-100">Отправить</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
