<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="editCustomer">
	<table class="table table-hover">
		<caption>고객정보 수정</caption>
		<tr>
			<td>이름</td>
			<td>
				<form:input path="name"/>
				<%-- <input type="text" name="name" id="name" value="${editCustomer.name }"> --%>
				<form:errors path="name" cssClass="err"></form:errors>
			</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>
				<form:input path="address"/>
				<form:errors path="address" cssClass="err"></form:errors>
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				<form:input path="email"/>
				<!-- cssClass="err" class="err"
				form:errors path="email" : email에 에러가 포함되어 있으면 보여줘라 -->
				<form:errors path="email" cssClass="err"></form:errors>
			</td>
		</tr>
		<tr>
			<td colspan="2"><button type="submit" value="process" name="event_process">다음</button></td>
		</tr>
	</table>
</form:form>
</body>
</html>