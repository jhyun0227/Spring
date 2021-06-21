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
<div class="container" align="center">
	<h2 class="text-primary">회원 가입</h2>
	<form action="member" method="post">
		<table class="table table-bordered">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" autofocus="autofocus" required="required"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="addr" required="required"></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="number" name="age" required="required"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<label for="m">남자</label>
					<input type="radio" name="gender" id="m" value="남자">
					<label for="f">여자</label>
					<input type="radio" name="gender" id="f" value="여자">
				</td>
			</tr>
			<tr>
				<td>취미</td>
				<td>
					<select name="hobby">
						<option value="게임">게임</option>
						<option value="음주">음주</option>
						<option value="가무">가무</option>
						<option value="울기">울기</option>
						<option value="싸우기">싸우기</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="확인"></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>