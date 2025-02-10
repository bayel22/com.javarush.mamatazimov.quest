<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Авторизация</title>
</head>

<body>

<h1>Знакомство</h1>

<p class="text-muted">
    Когда ты поднялся на борт корабля, тебя поприветствовала
    девушка с черной папкой в руках:
    – Здравствуйте, командир! Я Зинаида – ваша помощница.
    Видите? Там в углу пьет кофе наш штурман – сержант Перегарный Серж,
    под штурвалом спит наш бортмеханик – Черный Богдан.
    А как обращаться к вам?
</p>


<form action="hello-servlet" method="post">
    <label for="userName">Введите имя</label>
    <input id="userName" type="text" placeholder="Введи имя" required name="username">
    <button type="submit">Отправить</button>
</form>


</body>
</html>