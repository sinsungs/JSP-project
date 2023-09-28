<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="kss_mvc_rental.model.beer.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

    <link rel="stylesheet" href="<%= workDir %>/css/style.css">
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Wear Share</title>
</head>
<body>

<%@ include file="./header.jsp" %>

<%
	BeerDTO beer;
	ArrayList<BeerDTO> beerList;
	
	beerList = (ArrayList<BeerDTO>)request.getAttribute("beerList");
%>

	            <div class="content">
                <div class="null">
                    <h1 style="line-height:100px; text-align:center; color:blue">대여 중인 상품</h1>
                </div>
                <div class="sort">
                    <select class="input">
                        <option value="0">기본정렬</option>
                        <option value="1">최신순</option>
                        <option value="2">낮은 가격순</option>
                        <option value="3">높은 가격순</option>
                        <option value="4">리뷰 많은순</option>

                    </select>
                </div>
                <div class="content2">
                    <input class="input" type="text" placeholder="ex. 샤넬, 구찌" style="margin-top: 20px;">
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
                                <%-- <img src=<%=beer.getP_image() %> class="product-img"> --%>
                            </div>   
                            <div class="product-text">
                                <p style="font-weight: bold;"><%=beer.getP_store() %></p>
                                <p><%=beer.getP_name() %></p>
                                <p style="font-weight: bold;">1일 대여비 : <%=beer.getP_price()/10 %>원</p>
                                <br>
                                 <p style="font-weight: bold;">대여 시작 시간</p>
                                <p><%=beer.getP_time() %></p>
                                 <p style="font-weight: bold;">대여 종료 시간</p>
                                <p><%=beer.getP_endtime() %></p>
                                <button style="float:right;" onclick="location.href='./deleteShareForID.be?p_id=<%=beer.getP_id()%>';"><a>대여 종료</a></button> 

                            </div> 
                        </a>
                    </li>
                    
<%
	}
%>
                    
                </div>
               	<!-- content1 end -->
            </div>
            <!-- content end  -->
            
<%@ include file="./footer.jsp" %>
	
</body>
</html>