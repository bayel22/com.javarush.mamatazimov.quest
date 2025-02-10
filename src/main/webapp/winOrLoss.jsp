<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: drive
  Date: 10.02.2025
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:choose>
    <c:when test="${sessionScope.checkLossValue == true}">
        <h2>Вы проиграли 😔</h2>
        <br>
        <button type="submit" onclick="window.location.href='index.jsp'">Меню</button>
    </c:when>
    <c:when test="${sessionScope.checkAnswerWin == true}">
        <h2>Вы победили 🏆</h2>
        <br>
        <button type="submit" onclick="window.location.href='index.jsp'">Меню</button>
    </c:when>
</c:choose>

</body>
</html>
