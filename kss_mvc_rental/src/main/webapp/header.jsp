<%@page import="org.apache.commons.collections4.bag.SynchronizedSortedBag"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/globalData.jsp" %>
	    <link rel="stylesheet" href="<%= workDir %>/css/style.css?after">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	if( session.isNew()){
		System.out.println("세션 생성 확인용");
		session.setAttribute("loginState", "logout");
		session.setAttribute("userid", null);
		session.setAttribute("userpw", null);
		session.setAttribute("userRank", null);
		/* session.setAttribute("userRank", rs.getInt("mem_class")); */
	}
%>
<div class="header">
<div class="first">
<%-- <img src="<%= imgDir %>/first.jpg" alt="" style="width:100%; height:100px;">  --%>
</div>
<div class="wearshare">
<div class="wearshare2">
	<h1 class="logo"><a href="/kss_mvc_rental/index.jsp">WEAR SHARE</a></h1>
<%
		if(session.getAttribute("loginState").equals("login")){
%>
		
<!-- 		<form name="mypage" method="post"  style= "display:inline-block; float:right;">
			<input type="hidden" name="actionType" value="MYPAGE">
			<button type="submit"><a>마이페이지</a></button>
		</form> -->
		<form name="logout" method="post" action="./logoutUser.be" style= "display:inline-block; float:right; ">
		 <input type="hidden" name="actionType" value="LOGOUT">
		   <button type="button" onclick="location.href='./getCartList.be';"><a>장바구니</a></button> 
		  <button type="button" onclick="location.href='./getUserDisplay.be';"><a>마이페이지</a></button>
		  <%if(session.getAttribute("userRank") == "manager"){ %>
			<button type="button" onclick="location.href='./updateUserListDisplay.be';"><a>관리자페이지</a></button>
		  <% } %>
		  <button type="submit"><a>로그아웃</a></button>
		  
<%-- 			<%if((int)session.getAttribute("userRank") == 200){ %>
			<button type="button" onclick="location.href='/member01/adminPage.jsp?currentPageNo=0';">관리자페이지</button>
			<% } %> --%>
		 
		</form> 
		<p style="float:right;"><%=session.getAttribute("userid")%>님 로그인중.</p>
<%
		}
		else{
%>	
		 
		 <form name="login" method="post" action="./loginUser.be" style= "display:inline-block; float:right;">
		    아이디 : <input type="text" name="userid" size="10">
		    비밀번호 : <input type="password" name="userpw" size="10">
		    <input type="hidden" name="actionType" value="LOGIN">		    
		    <button type="submit"><a>로그인</a></button>
		    <button type="button" onclick="location.href='/kss_mvc_rental/join.jsp';" ><a>회원가입</a></button>
		    
		 </form>
		
<%
			if(session.getAttribute("loginState").equals("errorID")){
				out.print("[사용자ID오류]");
			}
			
			if(session.getAttribute("loginState").equals("errorPW")){
				out.print("[사용자PW오류]");
			}
		}
%>		

</div>
</div>
<%
		if(session.getAttribute("loginState").equals("login")){
%>
<%
		}
%>



            <nav>
                <ul>
                    <hr>
                    <li class="nav-menu"><a class="nav-text">입점 신청</a></li>
                    <li class="nav-menu"><a class="nav-text" href="./getShareList.be" style="color:blue">Share</a></li>
                    <li class="nav-menu"><a class="nav-text" href="./getBeerListForPage.be">전체 상품</a></li>
                    <li class="nav-menu"><a class="nav-text">지역 매장</a></li>
                    <li class="nav-menu"><a class="nav-text">리뷰</a></li>
                    <li class="nav-menu"><a class="nav-text">브랜드</a></li>
                    <hr>
                </ul>
            </nav>
            <!-- <div class="banner">
                배너 7개 슬라이드 
                <img src="https://image.brandi.me/home/banner/bannerImage_889638_1668072356.jpg" alt="">
            </div> -->
        </div>
<hr> 
</body>
</html>