<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="kss_mvc_rental.model.beer.*" %>
<%@ page import="java.util.*" %>


    <link rel="stylesheet" href="<%= workDir %>/css/style.css?after">

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Wear Share</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>

<%@ include file="./header.jsp" %>

<%

	BeerDTO beer;
	ArrayList<BeerDTO> beerList;
	BeerPageInfoVO bpiVO;
	
	bpiVO = (BeerPageInfoVO)session.getAttribute("beerPageInfoVO");
	beerList = (ArrayList<BeerDTO>)request.getAttribute("beerList");
	
	int currentPageNo = bpiVO.getCurrentPageNo();
%>
		
 		       <div class="content">
                <div class="null">
                    <h1 style="line-height:100px; text-align:center">전체 상품</h1>
                </div>
                <div class="sort" style="text-align:center">
                
                <%if(session.getAttribute("userRank") == "manager"){ %>
				<button style= "display:inline-block;" onclick="location.href='./admin_page.jsp'; "><a>관리자 상품 등록</a></button>
		  		<% } %>
		  		<%if(session.getAttribute("userRank") == "user"){ %>
				<button style= "display:inline-block;  background-color:blue;" onclick="location.href='./getShareList.be';"><a>대여 현황</a></button>
		  		<% } %>
		 
                
                    <select class="input">
                        <option value="0">기본정렬</option>
                        <option value="1">최신순</option>
                        <option value="2">낮은 가격순</option>
                        <option value="3">높은 가격순</option>
                        <option value="4">리뷰 많은순</option>

                    </select>
                </div>
                <div class="content2">
                 <h4 style="font-size: 16px;">상품명 검색</h4>
                <form action="./searchBeerList.be" method="post">
                    <input class="input" type="text" name="search" placeholder="ex. 자켓, 패딩" style="margin-top: 20px;">
                   	<button type="submit" style="background-color:white">검색</button>                
                </form>
                    <h4 style="font-size: 16px;">제품상태</h4>
                    <div class="rental" style="margin-bottom: 30px;">
                        <button><a>대여중</a></button>
                        <button><a>대여가능</a></button>
                    </div>

                    <div class="category">
                        <h1 style="margin-bottom: 10px;">CATEGORIES</h1>
                        <hr>
                        <div><h2 style="margin-bottom: 10px;">OUTER</h2></div>
                        <hr>
                        <div><h2 style="margin-bottom: 10px;">TOP</h2></div>
                        <hr>
                        <div><h2 style="margin-bottom: 10px;">BOTTOM</h2></div>
                        <hr>
                        <div><h2 style="margin-bottom: 10px;">SHOES</h2></div>
                        <hr>
                    </div>
                </div>
                

                <div class="content1">
                
	
<%
	for(int i=0; i < beerList.size(); i++) {
		beer = beerList.get(i);
%>		
                    <li class="product">
                        <a href="">
                            <div>
                                <img src="<%= imgDir %>/<%=beer.getP_image() %>" class="product-img">
                            </div>   
                            <div class="product-text">
                                <p style="font-weight: bold;"><%=beer.getP_store() %></p>
                                <p><%=beer.getP_name() %></p>
                                <p><%=beer.getP_price() %>원</p>
                                <p>1일 대여비 : <%=beer.getP_price()/10 %>원</p>
                                <p>상태 : <%=beer.getP_state() %></p>
                                <button class="put" onclick="location.href='./insertCartForID.be?p_id=<%=beer.getP_id()%>';"><a>장바구니 담기</a></button>
                                <button class="rental" onclick="location.href='./insertShareForID.be?p_id=<%=beer.getP_id()%>';"><a>대여 실행</a></button>
                                
                                <%if(session.getAttribute("userRank") == "manager"){ %>
				 				<a href="./updateBeerDisplay.be?p_id=<%=beer.getP_id()%>">UPDATE</a>
                                <a style="float:right;" href="./deleteBeerForID.be?p_id=<%=beer.getP_id()%>">DELETE</a>
		  						<% } %>
                
                               
                                
                            </div> 
                        </a>
                    </li>
<!--                     <button type="button" onclick="location.href='./getCartList.be?p_id=2';"><a>장바구니</a></button> -->
<%
	}
%>

<a href="./getBeerListForPage.be?currentPageNo=0">[FIRST]</a>
<%
	if( currentPageNo > 0){		
%>
	<a href="./getBeerListForPage.be?currentPageNo=<%=(currentPageNo-1) %>">[PRE]</a>
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
			<a href="./getBeerListForPage.be?currentPageNo=<%=i%>">[<%=(i+1)%>]</a>
<%
		}
	}
%>
<%
	if( currentPageNo < bpiVO.getPageCnt() - 1) {		
%>
	<a href="./getBeerListForPage.be?currentPageNo=<%=(currentPageNo+1)%>">[NXT]</a>
<%
	}else{
%>
	[NXT]	
<%
	}
%>
 	<a href="./getBeerListForPage.be?currentPageNo=<%=(bpiVO.getPageCnt()-1)%>">[END]</a>
 	
 	
                </div>
               	<!-- content1 end -->
            </div>
            <!-- content end  -->


<%@ include file="./footer.jsp" %>
</body>
</html>