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
	<div class="container">
		<h2 class="text-primary">구구단 선택</h2>
		<form action="gugu2">
			<table class="table table-bordered">
				<tr>
					<td><label for="g2">2</label>
					<input type="radio" name="num" id="g2" value="2"></td>
				</tr>
				<tr>
					<td><label for="g3">3</label>
					<input type="radio" name="num" id="g3" value="3"></td>
				</tr>
				<tr>
					<td><label for="g4">4</label>
					<input type="radio" name="num" id="g4" value="4"></td>
				</tr>
				<tr>
					<td><label for="g5">5</label>
					<input type="radio" name="num" id="g5" value="5"></td>
				</tr>
				<tr>
					<td><label for="g6">6</label>
					<input type="radio" name="num" id="g6" value="6"></td>
				</tr>
				<tr>
					<td><label for="g7">7</label>
					<input type="radio" name="num" id="g7" value="7"></td>
				</tr>
				<tr>
					<td><label for="g8">8</label>
					<input type="radio" name="num" id="g8" value="8"></td>
				</tr>
				<tr>
					<td><label for="g9">9</label>
					<input type="radio" name="num" id="g9" value="9"></td>
				</tr>
				<tr>
					<td><input type="submit" value="확인"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>