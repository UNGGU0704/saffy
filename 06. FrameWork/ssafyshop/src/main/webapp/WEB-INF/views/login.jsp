<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        .navbar {
            background-color: #333;
            color: white;
            padding: 10px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .navbar a {
            color: white;
            text-decoration: none;
            padding: 10px 15px;
        }

        .container {
            max-width: 400px; /* 조정 가능 */
            margin: 20px auto;
            padding: 20px;
            background-color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        input[type="text"], input[type="password"], input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #333;
            color: white;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #555;
        }
    </style>
</head>
<body>

<%@ include file="nav/nav.jsp" %>

  <c:if test="${not empty msg}">
        <script>
            alert("${msg}");
        </script>
    </c:if>
<div class="container">
    <h2>로그인</h2>
    <form action="${root}/login" method="post"> 
        <label for="id">아이디 :</label><br>
        <input type="text" id="id" name="id"  required="required"><br>
        <label for="password">비밀번호 :</label><br>
        <input type="password" id="password" name="password"  required="required"><br><br>
        <input type="submit" value="Login">
    </form>
</div>

</body>
</html>
