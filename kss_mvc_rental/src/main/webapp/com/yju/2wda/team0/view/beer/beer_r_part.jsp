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
<title>마이쇼핑몰(KDH17) - 맥주자료조회(R4,R41)</title>
</head>
<body>
<h1>마이쇼핑몰(KDH17) - 맥주자료조회(R4,R41)</h1>
<hr>
<%
	BeerDTO beer;
	ArrayList<BeerDTO> beerList;
	BeerPageInfoVO bpiVO;
	
	bpiVO = (BeerPageInfoVO)session.getAttribute("beerPageInfoVO");
	beerList = (ArrayList<BeerDTO>)request.getAttribute("beerList");
	
	int currentPageNo = bpiVO.getCurrentPageNo();
	String search = request.getParameter("search");
	String Part = request.getParameter("Part");
%>

<h2>현재 DISPLAY RECORDS NUMBER : <%= bpiVO.getLimitCnt() %></h2>   
<hr>
<form method="post" action="./BeerController.be?actionType=R_PART">
	부분 조회 기능 : 
	<select name="Part">
		<option SELECTED value="10">선택</option>		
		<option value="b_category">종류별</option>
		<option value="b_country">국가별</option>
		<option value="b_name">이름별</option>
		<option value="b_price">가격별</option>
	</select>

	<input type="text" name="search">
	<input type="hidden" name="currentPageNo" value="0">
	<input type="submit" value="검색">
</form>      

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
			</tr>
<%
	}
%>

		</tbody>
	</table>

<a href="<%= beerContDir %>/BeerController.be?actionType=R_PART&currentPageNo=0&Part=<%=Part%>&search=<%=search%>">[FIRST]</a>
<%
	if( currentPageNo > 0){		
%>
	<a href="<%= beerContDir %>/BeerController.be?actionType=R_PART&currentPageNo=<%=(currentPageNo-1) %>&Part=<%=Part%>&search=<%=search%>">[PRE]</a>
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
			<a href="<%= beerContDir %>/BeerController.be?actionType=R_PART&currentPageNo=<%=i%>&Part=<%=Part%>&search=<%=search%>">[<%=(i+1)%>]</a>
<%
		}
	}
%>
<%
	if( currentPageNo < bpiVO.getPageCnt() - 1) {		
%>
	<a href="<%= beerContDir %>/BeerController.be?actionType=R_PART&currentPageNo=<%=(currentPageNo+1)%>&Part=<%=Part%>&search=<%=search%>">[NXT]</a>
<%
	}else{
%>
	[NXT]	
<%
	}
%>
 	<a href="<%= beerContDir %>/BeerController.be?actionType=R_PART&currentPageNo=<%=(bpiVO.getPageCnt()-1)%>&Part=<%=Part%>&search=<%=search%>">[END]</a>

<br><a href="<%=rootDir %>/index.jsp">홈으로 돌아가기</a>
</body>
</html>