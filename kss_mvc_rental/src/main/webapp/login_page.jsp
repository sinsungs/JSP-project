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
<title>Insert title here</title>
</head>
<body>

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
                    <li class="product">
                        <a href="">
                            <div>
                                <img src="https://image.brandi.me/cproduct/2022/10/13/SB000000000043442917_1665672894_image1_S.jpeg" class="product-img">
                            </div>   
                            <div class="product-text">
                                <p style="font-weight: bold;">로댄티</p>
                                <p>53000</p>
                                <p>1일 대여비 : 5300원</p>
                                <p>상태 : 대여중</p>
                                <button class="put"><a>장바구니 담기</a></button>
                                <button class="rental"><a>대여 실행</a></button>
                            </div> 
                        </a>
                    </li>

                    <li class="product">
                        <a href="">
                            <div>
                                <img src="https://image.brandi.me/cproduct/2022/09/21/SB000000000072662544_1663742746_image1_S.jpeg" class="product-img">
                            </div>    
                            <div class="product-text">
                                <p style="font-weight: bold;">로니제이</p>
                                <p>40000원</p>
                                <p>1일 대여비 : 4000원</p>
                                <p>상태 : 대여가능</p>
                                <button class="put"><a>장바구니 담기</a></button>
                                <button class="rental"><a>대여 실행</a></button>
                            </div> 
                        </a>
                    </li>
                    <li class="product">
                        <a href="">
                            <div>
                                <img src="https://image.brandi.me/cproduct/2021/10/20/SB000000000012907483_1634721883_image1_S.jpeg" class="product-img">
                            </div>    
                            <div class="product-text">
                                <p style="font-weight: bold;">맨즈셀렉터</p>
                                <p class="price">53000원</p>
                                <p>1일 대여비 : 5300원</p>
                                <!-- <p>현재 재고량 : {{ remaindInventory }}</p> -->
                                <p>상태 : 대여중</p>
                                <button class="put"><a>장바구니 담기</a></button>
                                <button class="rental"><a>대여 실행</a></button>
                            </div> 
                        </a>
                    </li>

                    <li class="product">
                        <a href="">
                            <div>
                                <img src="https://image.brandi.me/cproduct/2022/11/11/SB000000000076780165_1668144997_image1_S.jpeg" class="product-img">
                            </div>  
                            <div class="product-text">
                                <p style="font-weight: bold;">마인드핏</p>
                                <p>33000원</p>
                                <p>1일 대여비 : 3300원</p>
                                <p>상태 : 대여가능</p>
                                <button class="put"><a>카트 담기</a></button>
                                <button class="rental"><a>대여 실행</a></button>
                            </div>   
                        </a>
                    </li>

                    <li class="product">
                        <a href="">
                            <div>
                                <img src="https://image.brandi.me/cproduct/2021/09/29/SB000000000040113435_1632892613_image1_S.jpeg" class="product-img">
                            </div>    
                            <div class="product-text">
                                
                                <p style="font-weight: bold;">제로스샵</p>
                                <p>33000원</p>
                                <p>1일 대여비 : 3300원</p>
                                <p>상태 : 대여중</p>
                                <button class="put"><a>카트 담기</a></button>
                                <button class="rental"><a>대여 실행</a></button>
                            </div> 
                        </a>
                    </li>

                    <li class="product">
                        <a href="">
                            <div>
                                <img src="https://image.brandi.me/cproduct/2022/10/12/SB000000000074925886_1665564699_image1_S.jpeg" class="product-img">
                            </div>    
                            <div class="product-text">
                                <p style="font-weight: bold;">단골스타일</p>
                                <p>90000원</p>
                                <p>1일 대여비 : 9000원</p>
                                <p>상태 : 대여가능</p>
                                <button class="put"><a>카트 담기</a></button>
                                <button class="rental"><a>대여 실행</a></button>
                            </div> 
                        </a>
                    </li>
                    
                     <li class="product">
                        <a href="">
                            <div>
                                <img src="https://image.brandi.me/cproduct/2022/10/12/SB000000000074925886_1665564699_image1_S.jpeg" class="product-img">
                            </div>    
                            <div class="product-text">
                                <p style="font-weight: bold;">단골스타일</p>
                                <p>90000원</p>
                                <p>1일 대여비 : 9000원</p>
                                <p>상태 : 대여가능</p>
                                <button class="put"><a>카트 담기</a></button>
                                <button class="rental"><a>대여 실행</a></button>
                            </div> 
                        </a>
                    </li>

                </div>
               	<!-- content1 end -->
            </div>
            <!-- content end  -->


  <%@ include file="./footer.jsp" %>

</body>
</html>