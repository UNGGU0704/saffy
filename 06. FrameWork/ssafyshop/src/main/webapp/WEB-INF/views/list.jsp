<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>상품 관리 사이트</title>
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
		<h1>상품 목록</h1>
		<form method="get">
			<label for="searchDate">날짜 검색:</label> <input type="date"
				id="searchDate" name="searchDate"> <input
				type="submit" value="검색">
		</form>
		<table>
			<tr>
				<th>Code</th>
				<th>Model</th>
				<th>Price</th>
				<th>ID</th>
				<th>Regist Date</th>
				<th>조회</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
			<c:forEach var="product" items="${products}">
			    <tr>
			        <td>${product.code}</td>
			        <td>${product.model}</td>
			        <td>${product.price}</td>
			        <td>${product.id}</td>
			        <td>${product.regist_date}</td>
			        
					<c:if test="${not empty sessionScope.user and (sessionScope.user.id eq 'admin' or sessionScope.user.id eq product.id)}">
	    				<td>
				            <a href="${root}/detailProduct?code=${product.code}">상세조회</a>
				        </td>
						<td>
				            <a href="${root}/updateProduct?code=${product.code}">수정</a>
				        </td>
						<td>
				            <a href="${root}/deleteProduct?code=${product.code}" onclick="return confirm('정말로 삭제하시겠습니까?');">삭제</a>
				        </td>
			        </c:if>
			    </tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
