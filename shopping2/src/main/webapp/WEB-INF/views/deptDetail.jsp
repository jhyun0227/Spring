<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$('#disp').load("deptList.do")
	});
</script>
</head>
<body>
<div class="container" align="center">
	<h2 class="text-primary">${dept.dname } 상세</h2>
	<table class="table table-striped table-bordered">
		<%-- <tr>
			<td rowspan="4" align="center"><img alt="" src="resources/img/${item.pictureUrl }"></td>
			<td>아이디</td><td>${item.itemId }</td>
		</tr> --%>
		<tr>
			<td>부서 번호</td>
			<td>${dept.deptno }</td>
		</tr>
		<tr>
			<td>부서 이름</td>
			<td>${dept.dname }</td>
		</tr>
		<tr>
			<td>지역</td>
			<td>${dept.loc }</td>
		</tr>
	</table>
<a href="deptList.do" class="btn btn-info">부서 목록</a>
<div id="disp"></div>
</div>
</body>
</html>