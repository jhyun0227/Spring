<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	// 글 삭제
	function rDelete(bno, rno) {
		var sendData = 'bno='+bno+'&rno='+rno;
		$.post('${path}/rDelete', sendData, function(data) {
			alert("댓글이 삭제 되었습니다.");
			$('#rbdListDisp').html(data);
		});
	}
	
	// 글 수정
	function rUpdate(bno, rno) {
		/* input에 있는 데이터 읽어서 textarea에 넣어서 변경 해야 함
		input, textarea(form tag안)에 데이터를 읽을 때 jquery에서 val()
		td(일단 tag안)에 있는 데이터를 읽을 때는 jquery에서는 text() */
		var txt = $('#td_'+rno).text();
		/* 댓글 처리 클릭한 위치에 있는 문장을 텍스트 에어리어로 넣기 */
		$('#td_'+rno).html("<textarea rows='3' cols='30' id='rt'>" + 
				txt + "</textarea>");
		/* 버튼 처리 클릭한 위치에 있는 수정 버튼을 확인과 취소로 변경*/
		$('#btn_'+rno).html("<input type='button' onclick='up("+bno+","+rno+")' class='btn btn-sm btn-danger' value='확인'>" + 
				"<input type='button' onclick='lst("+bno+")' class='btn btn-info btn-sm' value='취소'>");
	}
	
	// 글 수정 update(헷갈릴 까봐 이름 변경)
	function up(bno, rno) {
		var sendData = "replytext="+$('#rt').val()+"&bno="+bno+"&rno="+rno;
		$.post('${path}/rUpdate', sendData, function(data) {
			alert("수정 되었습니다.");
			$('#rbdListDisp').html(data);
		});
	}
	
	// 글 목록 list(헷갈릴 까봐 이름 변경)
	function lst(bno) {
		$('#rbdListDisp').load("${path}/replyList/bno/"+bno);
	}
</script>
</head>
<body>
<c:if test="${not empty rbdList }">
	<h3 class="text-primary">댓글</h3>
	<table class="table table-striped">
		<tr>
			<td>작성자</td>
			<td>내용</td>
			<td>수정일</td>
			<td></td>
		</tr>
		<c:forEach var="rbd" items="${rbdList }">
			<c:if test="${rbd.del == 'y' }">
				<tr>
					<td colspan="4">삭제된 댓글입니다.</td>
				</tr>
			</c:if>
			<c:if test="${rbd.del != 'y' }">
				<tr>
					<td>${rbd.replyer }<!-- 작성자 --></td>
					<td id="td_${rbd.rno}">${rbd.replytext }<!-- 내용 --></td>
					<td>${rbd.updatedate }<!-- 수정일 --></td>
					<!-- 원래라면 댓글 작성자와 로그인한 사람의 아이디/이름을 비교해서 같으면 수정/삭제 권한 제공 -->
					<!-- 현재 하는 것은 회원게시판이 아니기 때문에 게시글 작성자와 댓글 작성자가 같으면 임시로 권한 제공 -->
					<c:if test="${rbd.replyer == board.writer }">
						<td id="btn_${rbd.rno }">
							<input type="button" value="수정" class="btn btn-warning" onclick="rUpdate(${rbd.bno}, ${rbd.rno })">
							<input type="button" value="삭제" class="btn btn-danger" onclick="rDelete(${rbd.bno}, ${rbd.rno })">
						</td>
					</c:if>
					<c:if test="${rbd.replyer != board.writer }">
						<td></td>
					</c:if>
				</tr>
			</c:if>
		</c:forEach>
	</table>
</c:if>
</body>
</html>