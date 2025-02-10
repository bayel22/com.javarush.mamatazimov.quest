<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
  <h1><%= "КВЕСТ" %></h1>
  <br/>

  <h2>Пролог</h2>

  <div>
    <p class="prologue"> Ты стоишь в космическом порту и готов подняться на борт
      своего корабля. Разве ты не об этом мечтал?
      Стать капитаном галактического судна с экипажем,
      который будет совершать подвиги под твоим командованием.
      Так что вперед!
    </p>
  </div>
  <br>

  <div class="start-page" id="startPage">
    <c:choose>
      <c:when test="${sessionScope.user == null}">
        <h1>Добро пожаловать!</h1>
      </c:when>
      <c:otherwise>
        <h1>Добро пожаловать ${sessionScope.user}!</h1>
        <br>
        <div>
          <h3>Статистика</h3>
          <p>Имя: ${sessionScope.user}</p>
          <p>Побед: ${sessionScope.countWin}</p>
          <p>Проигрышей: ${sessionScope.countLoss}</p>
        </div>
        <br>
      </c:otherwise>
    </c:choose>
  </div>

  <form action="hello-servlet" method="post">
    <button type="submit">Начать квест</button>
  </form>
</body>
</html>