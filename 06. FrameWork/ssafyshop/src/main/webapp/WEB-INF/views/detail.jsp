<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품 상세 조회</title>
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
            max-width: 1200px;
            margin: 20px auto;
            padding: 20px;
            background-color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            margin-top: 20px;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        form {
            margin-bottom: 20px;
        }

        input[type="date"], input[type="submit"] {
            padding: 8px;
        }
    </style>
</head>
<body>

	<%@ include file="nav/nav.jsp" %>

    <div class="container">
        <h1>상품 상세 조회</h1>
        <table>
            <tr>
                <th>Code</th>
                <th>Model</th>
                <th>Price</th>
                <th>ID</th>
                <th>Regist Date</th>
            </tr>
            <tr>
                <td>${product.code}</td>
                <td>${product.model}</td>
                <td>${product.price}</td>
                <td>${product.id}</td>
                <td>${product.regist_date}</td>
            </tr>
        </table>
		<tr>
		    <th>
		        <div style="border: 1px solid #ccc; padding: 10px;">
		            <h2>상세 설명</h2>
		            <p>${product.detail}</p>
		        </div>
		    </th>
		</tr>
		
		<br>
		<br>
		
		<div>
		    <form action="${root}/updateProduct" method="get" style="display: inline;">
		        <input type="hidden" name="code" value="${product.code}">
		        <button type="submit">수정</button>
		    </form>
		    <form action="${root}/deleteProduct" method="get" onsubmit="return confirm('정말로 삭제하시겠습니까?');" style="display: inline;">
		        <input type="hidden" name="code" value="${product.code}">
		        <button type="submit">삭제</button>
		    </form>
		</div>
	

    </div>
</body>
</html>
