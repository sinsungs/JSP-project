<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="kss_mvc_rental.model.beer.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이쇼핑몰(KDH17) - 맥주자료수정(U2)</title>
</head>
<body>

<%@ include file="/header.jsp" %>

<%
	BeerDTO beer = (BeerDTO)request.getAttribute("beer");
%>

<form method="post" action="./updateBeerForID.be" >
	<br>맥주번호(수정불가) : <input type="text" name="p_id" value="<%=beer.getP_id()%>" size="30">
	<br>종류 : <input type="text" name="p_category" value="<%=beer.getP_category()%>" size="30">
	<br>매장명 : <input type="text" name="p_store" value="<%=beer.getP_store()%>" size="30">
	<br>상품이름 : <input type="text" name="p_name" value="<%=beer.getP_name()%>"size="30">
	<br>상품가격 : <input type="text" name="p_price" value="<%=beer.getP_price()%>" size="30">
	<br>상태 : <input type="text" name="p_state" value="<%=beer.getP_state()%>" size="30">
	<br>좋아요 : <input type="text" name="p_like" value="<%=beer.getP_like()%>" size="30">
	<br>사진 : <input type="text" name="p_image" value="<%=beer.getP_image()%>" size="30">
<!-- 	<br><input type="hidden" name="actionType" value="U_ID"> -->
	<br><input type="submit" value="저장">
	
</form>


<br><a href="<%= rootDir %>/index.jsp">홈으로 돌아가기</a>

</body>
</html>