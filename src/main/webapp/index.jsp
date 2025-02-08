<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
  <h1><%= "КВЕСТ" %></h1>
  <br/>
  <div class="welcomeText">
    <h1>Добро пожаловать!</h1>
  </div>

  <form action="hello-servlet" method="post">
    <button type="submit">Начать квест</button>
  </form>
</body>
</html>