<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="kss_mvc_rental.model.beer.*" %>
<%@ page import="java.util.*" %>
<%@ include file="/globalData.jsp" %>
    <link rel="stylesheet" href="<%= workDir %>/css/style.css">
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이쇼핑몰(KDH17) - 맥주자료조회(R)</title>
</head>
<body>
<h1>마이쇼핑몰(KDH17) - 맥주자료조회(R)</h1>
<hr>
<h2>전체보기(부분조회,페이징기능 미포함)</h2>


<%
	BeerDTO beer;
	ArrayList<BeerDTO> beerList;
	
	beerList = (ArrayList<BeerDTO>)request.getAttribute("beerList");
%>

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
	

	            <div class="content">
                <div class="null">
                    <h1 style="line-height:100px; text-align:center">전체 상품</h1>
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
                                <img src=<%=beer.getP_image() %> class="product-img">
                            </div>   
                            <div class="product-text">
                                <p style="font-weight: bold;"><%=beer.getP_store() %></p>
                                <p><%=beer.getP_name() %></p>
                                <p><%=beer.getP_price() %>원</p>
                                <p>1일 대여비 : <%=beer.getP_price()/10 %>원</p>
                                <p>상태 : <%=beer.getP_state() %></p>
                                <button class="put"><a>장바구니 담기</a></button>
                                <button class="rental"><a>대여 실행</a></button>
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
            

<br><a href="<%=rootDir %>/index.jsp">홈으로 돌아가기</a>
</body>
</html>