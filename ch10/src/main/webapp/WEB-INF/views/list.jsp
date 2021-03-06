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
	<h2 class="text-primary">게시글 목록</h2>
	<table class="table table-bordered">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>작성일</th>
		</tr>
		<c:if test="${empty list }">
			<tr>
				<th colspan="5">게시글이 없습니다.</th>
			</tr>
		</c:if>
		<c:if test="${not empty list }">
			<c:forEach var="board" items="${list }">
				<tr>
					<td>${num }<c:set var="num" value="${num - 1 }"></c:set>
					<%-- <td>${board.num }</td> --%>
					<c:if test="${board.del == 'y' }">
						<th colspan="4">삭제된 게시글 입니다.</th>
					</c:if>
					<c:if test="${board.del != 'y' }">
						<td title="${board.content }">
						
							<!-- 답변글 -10 px씩 들여쓰기 -->
							<c:if test="${board.re_level > 0 }">
								<img alt="" src="${path }/resources/images/level.gif" height="5" width="${board.re_level*10 }" >
								<img alt="" src="${path }/resources/images/re.gif" >			
							</c:if>
							
						<a class="btn btn-info btn-sm" href="${path }/view/num/${board.num }/pageNum/${pb.currentPage}">${board.subject }</a>
						
							<!-- 조회수가 50이 넘으면 인기 글 -->						
							<c:if test="${board.readcount > 50 }">
								<img alt="" src="${path }/resources/images/hot.gif" >
							</c:if>
						</td>
						<td>${board.writer }</td>
						<td>${board.readcount }</td>
						<td>${board.reg_date }</td>
					</c:if>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	
	<!-- 페이징 시작 -->
	<div align="center">
		<ul class="pagination">
			<!-- 시작 페이지가 pagePerBlock(10) 보다 크면 앞에 보여줄 페이지가 있음 -->
			<c:if test="${pb.startPage > pb.pagePerBlock }">
				<!-- 첫 페이지로 -->
				<li>
					<a href="${path }/list/pageNum/1?search=${board.search }&keyword=${board.keyword}"><span class="glyphicon glyphicon-backward"></span></a>
				</li>
				<!-- 전 블록으로 -->
				<li>
					<a href="${path }/list/pageNum/${pb.startPage-1 }?search=${board.search }&keyword=${board.keyword}"><span class="glyphicon glyphicon-triangle-left"></span></a>
				</li>
			</c:if>
			
			<c:forEach var="i" begin="${pb.startPage }" end="${pb.endPage }">
				<c:if test="${pb.currentPage == i }">
					<!-- class="active" 보고 있는 페이지를 확인하기 쉽게 -->
					<li class="active">
						<a href="${path }/list/pageNum/${i }?search=${board.search }&keyword=${board.keyword}">${i }</a>
					</li>
				</c:if>
				<c:if test="${pb.currentPage != i }">
					<li>
						<a href="${path }/list/pageNum/${i }?search=${board.search }&keyword=${board.keyword}">${i }</a>
					</li>
				</c:if>
			</c:forEach>
			
			<!-- 보여줄 것이 많은 경우는 다음 endPage보다 totalPage가 클 경우-->
			<c:if test="${pb.endPage < pb.totalPage }">
				<!-- 다음 블록으로 -->
				<li>
					<a href="${path }/list/pageNum/${pb.endPage + 1 }?search=${board.search }&keyword=${board.keyword}"><span class="glyphicon glyphicon-triangle-right"></span></a>
				</li>
				<!-- 마지막 페이지로 -->
				<li>
					<a href="${path }/list/pageNum/${pb.totalPage }?search=${board.search }&keyword=${board.keyword}"><span class="glyphicon glyphicon-forward"></span></a>
				</li>
			</c:if>
		</ul>
	</div>
	<!-- 페이징 끝 -->
	
	<!-- 검색 시작 -->
	<form action="${path }/list/pageNum/1">
		<!-- <select name="search">
			<option value="writer">작성자</option>
			<option value="subject">제목</option>
			<option value="content">내용</option>
		</select> -->
		<select name="search">
			<c:forTokens var="sh" items="writer, subject, content, subcon" delims=", " varStatus="i">
				<c:if test="${sh == board.search }">
					<option value="${sh }" selected="selected">${title[i.index] }</option>
				</c:if>
				<c:if test="${sh != board.search }">
					<option value="${sh }">${title[i.index] }</option>
				</c:if>	
			</c:forTokens>
		</select>
		<input type="text" name="keyword" value="${board.keyword }">
		<input type="submit" value="확인">
	</form>
	<!-- 검색 끝 -->
	
	<div align="center">
		<a href="${path }/insertForm/num/0/pageNum/1" class="btn btn-success">게시글 입력</a>
	</div>
</div>
</body>
</html>