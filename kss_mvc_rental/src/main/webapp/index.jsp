<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file="./header.jsp" %>
<%
	if(session.getAttribute("loginState").equals("login")){
%>
		<%--  <%@ include file = "./getBeerListForPage.be" %> --%>
		<%-- <jsp:include page="./login_page.jsp"/> --%>
		<script>
		location.href="./getBeerListForPage.be";
		</script>
<%
	}else{
%>
		 <jsp:include page="./logout_page.jsp"/>
		 
<%
	}
%>		 
<%-- <ul>
<li><a href="./BeerController.be?actionType=R_PART">부분 조회 기능 추가(R_PART)</a> 
<li><a href="<%= beerViewDir %>/beer_r_drc.jsp">출력레코드갯수조정(R_DRC)</a> 
<li><a href="<%= beerViewDir %>/beer_c.jsp">맥주정보입력(C)</a>
<li><a href="./getBeerList.be">맥주정보조회(R,페이징기능X)</a>
<li><a href="./getBeerListForPage.be">맥주정보조회(R4,MVC패턴적용)</a>
<li><a href="./updateBeerListDisplay.be">맥주정보수정(U,MVC패턴적용)</a>
<li><a href="<%= rootDir %>/admin_page.jsp">관리페이지(C)</a>
</ul>  --%>
<%@ include file="./footer.jsp" %>

</body>
</html>
