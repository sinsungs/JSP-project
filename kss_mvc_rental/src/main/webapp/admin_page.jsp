<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/header.jsp" %>
<form method="post" action="./insertBeer.be" enctype="multipart/form-data" style="width:350px; margin-left: auto; margin-right: auto;">

	<br>매장명: <input type="text" name="p_store" size="30">
	<br>카테고리 : <input type="text" name="p_category" size="30">
	<br>상품명 : <input type="text" name="p_name" size="30">
	<br>상품가격 : <input type="text" name="p_price" size="30">
	<br>상품상태 : <input type="text" name="p_state" size="30">
<!-- 	<br>상품이미지 : <input type="text" name="p_image" size="30"> -->
	<br>상품이미지 : <input type="file" name="p_image" size="30">
<!-- 	<br><input type="hidden" name="actionType" value="C"> -->
	<br><input type="submit" value="상품등록">
</form>

</body>

</html>
