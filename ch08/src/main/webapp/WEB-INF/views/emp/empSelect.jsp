<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$('#empList').load("empList.html table", "deptno=${emp.deptno}")
	});
	
	function del(empno) {
		var cf = confirm("정말로 삭제하시겠습니까?");
		if (cf) {
			location.href="empDelete.html?empno=" + empno;
		} else {
			alert("삭제가 취소되었습니다.");
		}
	}
</script>
</head>
<body>
<div class="container" align="center">
	<h2 class="text-primary>">직원정보 상세</h2>
	<table class="table table-bordered">
		<tr>
			<td>사번</td>
			<td>${emp.empno }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${emp.ename }</td>
		</tr>
		<tr>
			<td>업무</td>
			<td>${emp.job }</td>
		</tr>
		<tr>
			<td>관리자</td>
			<td>${emp.mgr }</td>
		</tr>
		<tr>
			<td>입사일</td>
			<td>${emp.hiredate }</td>
		</tr>
		<tr>
			<td>급여</td>
			<td>${emp.sal }</td>
		</tr>
		<tr>
			<td>커미션</td>
			<td>${emp.comm }</td>
		</tr>
		<tr>
			<td>부서 번호</td>
			<td>${emp.deptno }</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<a class="btn btn-info btn-sm" href="empList.html?deptno=${emp.deptno }">직원 목록</a>
				<a class="btn btn-warning btn-sm" href="empUpdateForm.html?empno=${emp.empno }">수정</a>
				<a class="btn btn-danger btn-sm" onclick="del(${emp.empno})">삭제</a>
				<a class="btn btn-success btn-sm" href="deptList.html">부서 목록</a>
			</td>
			</tr>
	</table>
	<div id="empList"></div>
</div>
</body>
</html>