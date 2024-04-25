<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<div class="navbar">
    <div>
        <a href="${root }">상품 관리</a>
    </div>
    <div>
        <c:if test="${empty sessionScope.user}">
        	<a href="${root}/signup">회원가입</a>
            <a href="${root}/login">로그인</a>
        </c:if>
        <c:if test="${not empty sessionScope.user}">
            ${sessionScope.user.name}님, 로그인 하였습니다.
            <a href="${root}/logout">로그아웃</a>
            <a href="${root}/list">상품 목록</a>
        	<a href="${root}/regist">상품 정보 등록</a>
        </c:if>
    </div>
</div>
