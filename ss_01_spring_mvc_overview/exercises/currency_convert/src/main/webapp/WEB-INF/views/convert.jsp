<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 8/15/2022
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Convert</title>

    <style>
        label, input, button {
            font-size: 27px;
            margin: 10px;
        }
    </style>

</head>
<body>

<form method="post" action="">
    <label> USD : </label>
    <input type="text" name="usd" placeholder="USD"><br>
    <label>VND :</label>
    <input type="text" value="${result}"><br>
    <button type="submit"> Chuyển đổi</button>
</form>

</body>
</html>