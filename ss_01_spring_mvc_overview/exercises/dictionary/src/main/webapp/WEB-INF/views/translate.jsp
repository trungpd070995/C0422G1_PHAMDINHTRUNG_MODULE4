<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 8/15/2022
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style>
        label, input, button {
            font-size: 27px;
            margin: 10px;
        }
    </style>

</head>
<body>

<form method="post" action="">
    <label> English : </label>
    <input type="text" name="english" placeholder="English"><br>
    <label> Vietnamese : </label>
    <input type="text" value="${result}"><br>
    <button type="submit"> Tra từ </button>
</form>

</body>
</html>
