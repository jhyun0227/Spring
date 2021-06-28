<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${result > 0 }">
	<script type="text/javascript">
		alert("입력 성공");
		/* 입력한 직원정보를 보내서 제대로 입력 됐는지 확인하기 위해 사번 추가  */
		location.href="empSelect.html?empno=${emp.empno}";
	</script>
</c:if>
<c:if test="${result == 0 }">
	<script type="text/javascript">
		alert("입력 실패")
		history.go(-1);
	</script>
</c:if>
<c:if test="${result < 0 }">
	<script type="text/javascript">
		alert("이미 존재하는 사번 입니다");
		history.back();
	</script>
</c:if>
</body>
</html>