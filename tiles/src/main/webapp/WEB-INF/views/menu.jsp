<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<h2 class="text-primary">메뉴</h2>
	<table class="table">
		<tr>
			<td><a href="${path }/home/home" class="btn btn-success">홈</a></td>
		</tr>
		<tr>
			<td><a href="${path }/home/first" class="btn btn-info">정은지</a></td>
		</tr>
		<tr>
			<td><a href="${path }/test/second" class="btn btn-warning">프로듀스</a></td>
		</tr>
		<tr>
			<td><a href="${path }/test/third" class="btn btn-danger">트와이스</a></td>
		</tr>
		<tr>
			<td><a href="${path }/nolayout/test1" class="btn btn-default">레이아웃 없음</a></td>
		</tr>
	</table>
</div>
</body>
</html>