<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 8/16/2022
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Sandwich Condiments</h2>
  <div class="container-fluid">
    <form action="/save" method="post">
      <c:forEach items="${condiment}" var="condiment">
      <input type="checkbox" value="${condiment}" name="select"><label>${condiment}</label>
        </c:forEach>
      <input type="submit" value="save">
    </form>
    <c:if test="${save != null}">
      <h1>Condiments:</h1>
      <c:forEach items="${save}" var="save">
        <p>${save}</p>
      </c:forEach>
    </c:if>
  </div>
  </body>
</html>
