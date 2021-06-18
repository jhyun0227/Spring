<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container" align="center">
		<h2 class="text-primary">부서 목록</h2>
		<table class="table table-striped table-bordered">
			<tr>
				<th>부서 번호</th>
				<th>부서 이름</th>
				<th>지역</th>
			</tr>
			<c:forEach var="dept" items="${list }">
				<tr>
					<td>${dept.deptno }</td>
					<td><a href="deptDetail.do?dname=${dept.dname }" class="btn btn-success bt-sm">${dept.dname }</a></td>
					<td>${dept.loc }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>