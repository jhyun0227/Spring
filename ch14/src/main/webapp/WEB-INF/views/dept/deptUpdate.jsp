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
<c:if test="${result != null}">
	<script type="text/javascript">
		alert("정보 수정 성공");
		location.href="deptList.html";
	</script>
</c:if>
<c:if test="${result == null }">
	<script type="text/javascript">
		alert("정보 수정 실패")
		history.go(-1);
	</script>
</c:if>
</body>
</html>