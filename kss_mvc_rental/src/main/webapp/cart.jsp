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
<title>Insert title here</title>
</head>
<body>


<%
	BeerDTO beer;
	ArrayList<BeerDTO> beerList;
	
	beerList = (ArrayList<BeerDTO>)request.getAttribute("beerList");
%>

<%@ include file="./header.jsp" %>


<div class="content">
          <div class="null">
                    <h1 style="line-height:100px; text-align:center">장바구니</h1>
                </div>

                  <h2><strong>상품 정보</strong></h2>
                  <hr>
                  
<%
	for(int i=0; i < beerList.size(); i++) {
		beer = beerList.get(i);
%>	
                  <div class="form">
                  <div class="order_item" style="width:100%; height:250px;">
                  <ul>
                    <li style="width:100%; height: 70px; " >
                        <div style="width:200px; display:inline-block;line-height: 70px;">
                          <%=beer.getP_store() %>
                        </div> 
                        <div style="width:650px; display:inline-block;line-height: 70px;">
                        </div> 
                        <div style="width:250px; display:inline-block;line-height: 70px;">쿠폰적용</div>
                        <div style="width:200px; display:inline-block;line-height: 70px;">상품금액</div>
                    </li>
                    <hr>
                    <li style="width:100%; height: 130px;" >
                        <div style="width:200px; display:inline-block;">
                          <img style="width:130px; height:130px;" src="<%= imgDir %>/<%=beer.getP_image() %>" alt="[특가] [로랑051 그레이 당일출고] 베이직 루즈핏 퍼 자켓(3color) 상품 썸네일">
                        </div> 
                        <div style="width:650px; display:inline-block;line-height: 130px;"><span><%=beer.getP_name() %></span> <span>1개</span>
                        </div> 
                        <div style="width:250px; display:inline-block;line-height: 130px;">적용 가능한 쿠폰이 없습니다.</div>
                        <div style="width:200px; display:inline-block;line-height: 130px;"><%=beer.getP_price() %></div>
                    </li>
                    <hr>
                  <li div class="price_sum" style="width:100%; height:50px;">
					<button style="float:right;" onclick="location.href='./deleteCartForID.be?p_id=<%=beer.getP_id()%>';"><a>선택 삭제</a></button> 
                  </li>
    				<hr>
                  </div>
                  </ul>
                  
                  </div>
<%
	}
%>
				
				<!-- <h2><strong>총 결제금액 : </strong></h2> -->
				<button onclick="location.href='./order.jsp';"><a>구매하기</a></button>
<%-- <%			<button class="updateBtn" onclick="location.href='./updateUserDisplay.be';">회원정보 수정</button>
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
                                <button class="rental"><a>대여 실행</a></button>
                                <a href="./updateBeerDisplay.be?p_id=<%=beer.getP_id()%>">UPDATE</a>
                                <a style="float:right;" href="./deleteBeerForID.be?p_id=<%=beer.getP_id()%>">DELETE</a>
                                
                            </div> 
                        </a>
                    </li>
<%
	}
%> --%>

</body>
</html>