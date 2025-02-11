<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Космический квест</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <link href="css/style.css" rel="stylesheet">
</head>
<body>
<div class="main-container">
  <c:if test="${not empty sessionScope.user}">
    <div class="statistics-box">
      <h3 class="mb-4">Ваша статистика</h3>
      <div class="mb-4">
        <p class="fs-5"><strong>Имя:</strong> ${sessionScope.user}</p>
        <p class="fs-5"><strong>Побед:</strong> ${sessionScope.countWin}</p>
        <p class="fs-5"><strong>Проигрышей:</strong> ${sessionScope.countLoss}</p>
      </div>
      <form action="hello-servlet" method="post">
        <button name="restartButton" class="restart-button">
          Заново
        </button>
      </form>
    </div>
  </c:if>
  <div class="content-box">
    <div class="text-center">
      <h1 class="display-4 mb-5">🚀 Космический квест</h1>
      <div class="prologue-text">
        <p>Ты стоишь в космическом порту и готов подняться на борт своего корабля.</p>
        <p>Разве ты не об этом мечтал? Стать капитаном галактического судна с экипажем,
          который будет совершать подвиги под твоим командованием.</p>
        <p class="fw-bold">Так что вперед!</p>
      </div>
      <form action="hello-servlet" method="post">
        <button type="submit" class="btn btn-primary quest-button">
          Начать квест
        </button>
      </form>
    </div>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>