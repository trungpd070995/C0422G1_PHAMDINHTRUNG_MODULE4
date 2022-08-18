<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 8/17/2022
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h2>Email information</h2>
<table>
    <tr>
        <td>Languages:</td>
        <td>${emailSetting.languages}</td>
    </tr>
    <tr>
        <td>Page size:</td>
        <td>${emailSetting.pageSize}</td>
    </tr>
    <tr>
        <td>Spam filter:</td>
        <td>${emailSetting.spamsFilter}</td>
    </tr>
    <tr>
        <td>Signature:</td>
        <td>${emailSetting.signature}</td>
    </tr>
</table>
</body>
</html>
