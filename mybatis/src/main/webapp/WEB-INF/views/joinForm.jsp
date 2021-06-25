<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function idChk() {
		if (!frm.id.value) {
			alert("아이디를 입력한 후에 체크하세요.");
			frm.id.focus();
			return false
		}
		// id를 입력했던 jquery의 ajax를 사용해 보자
		// data는 Controller에서 보내준 데이터(jsp에 보이는 데이터)
		// data에는 컨트롤러에서 보내준 msg에 담겨있는 문자를 받아서 저장
		$.post('idChk.do', 'id='+frm.id.value, function(data) {
			$('#idChk').html(data);
		});
	}
	function chk() {
		if (frm.password.value != frm.password2.value) {
			alert("암호와 암호 확인이 일치하지 않습니다.");
			frm.password.focus(); // 커서
			frm.password.value=""; // password에 있는 데이터를 지우기
			return false; // action을 실행하지 않음
		}
	}
</script>
</head>
<body>
<div class="container" align="center">
	<h2 class="text-primary">회원 가입</h2>
	<form action="join.do" method="post" enctype="multipart/form-data" name="frm" 
	onsubmit="return chk()">
		<table class="table table-bordered table-hover">
			<tr>
				<td>아이디<span class="glyphicon glyphicon-user"></span></td>
				<td>
					<input type="text" name="id" required="required" autofocus="autofocus">
					<input type="button" onclick="idChk()" class="btn btn-info btn-sm" value="중복체크">
					<div id="idChk" class="err"></div>
				</td>
			</tr>
			<tr>
				<td>암호<span class="glyphicon glyphicon-lock"></span></td>
				<td><input type="password" name="password" required="required"></td>
			</tr>
			<tr>
				<td>암호 확인<span class="glyphicon glyphicon-lock"></span></td>
				<td><input type="password" name="password2" required="required"></td>
			</tr>
			<tr>
				<td>이름<span class="glyphicon glyphicon-user"></span></td>
				<td><input type="text" name="name" required="required"></td>
			</tr>
			<tr>
				<td>이메일<span class="glyphicon glyphicon-envelope"></span></td>
				<td><input type="email" name="email" required="required"></td>
			</tr>
			<tr>
				<td>사진<span class="glyphicon glyphicon-picture"></span></td>
				<td><input type="file" name="file" required="required"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="회원가입" class="btn btn-danger"></td>
			</tr>
		</table>
		<a href="loginForm.do" class="btn btn-success">로그인</a>
	</form>
</div>
</body>
</html>