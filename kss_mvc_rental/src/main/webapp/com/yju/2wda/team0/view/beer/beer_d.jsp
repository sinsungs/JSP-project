<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="kss_mvc_rental.model.beer.*" %>
<%@ page import="java.util.*" %>
<%@ include file="/globalData.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이쇼핑몰(KDH17) - 맥주자료삭제(D)</title>
</head>
<body>
<h1>마이쇼핑몰(KDH17) - 맥주자료삭제(D)</h1>
<hr>
<%
	BeerDTO beer;
	ArrayList<BeerDTO> beerList;
	BeerPageInfoVO bpiVO;
	
	bpiVO = (BeerPageInfoVO)session.getAttribute("beerPageInfoVO");
	beerList = (ArrayList<BeerDTO>)request.getAttribute("beerList");
	
	int currentPageNo = bpiVO.getCurrentPageNo();
%>

<h2>현재 DISPLAY RECORDS NUMBER : <%= bpiVO.getLimitCnt() %></h2>
<hr>
<br>
	<table border="1">
		<thead>
			<tr>
				<th>순번</th>
				<th>카테고리</th>
				<th>매장명</th>
				<th>이름</th>
				<th>가격</th>
				<th>상태</th>
				<th>좋아요</th>
				<th>사진</th>
				<th>삭제</th>
			</tr>
		</thead>		
		<tbody>
		
<%
	for(int i=0; i < beerList.size(); i++) {
		beer = beerList.get(i);
%>		
			<tr>
				<td><%=beer.getP_id() %></td>
				<td><%=beer.getP_category() %></td>
				<td><%=beer.getP_store() %></td>
				<td><%=beer.getP_name() %></td>
				<td><%=beer.getP_price() %></td>
				<td><%=beer.getP_state() %></td>
				<td><%=beer.getP_like() %></td>
				<td><%=beer.getP_image() %></td>
				<td><a href="./deleteBeerForID.be?p_id=<%=beer.getP_id()%>">DELETE</a>
			</tr>
<%
	}
%>
		</tbody>
	</table>

<a href="./deleteBeerListDisplay.be?currentPageNo=0">[FIRST]</a>
<%
	if( currentPageNo > 0){		
%>
	<a href="./deleteBeerListDisplay.be?currentPageNo=<%=(currentPageNo-1) %>">[PRE]</a>
<%
	}else{
%>	
	[PRE]
<%
	}

	for(int i = bpiVO.getStartPageNo(); i < bpiVO.getEndPageNo(); i++) {
		
		if( i == currentPageNo ) {
%>
		[<%=(i+1) %>]
<%
		}else{
%>
			<a href="./deleteBeerListDisplay.be?&currentPageNo=<%=i%>">[<%=(i+1)%>]</a>
<%
		}
	}
%>
<%
	if( currentPageNo < bpiVO.getPageCnt() - 1) {		
%>
	<a href="./deleteBeerListDisplay.be?&currentPageNo=<%=(currentPageNo+1)%>">[NXT]</a>
<%
	}else{
%>
	[NXT]	
<%
	}
%>
 	<a href="./deleteBeerListDisplay.be?&currentPageNo=<%=(bpiVO.getPageCnt()-1)%>">[END]</a>

<br><a href="<%=rootDir %>/index.jsp">홈으로 돌아가기</a>
</body>
</html>