<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Wear Share</title>
</head>
<body>

<%@ include file="/header.jsp" %>

<div class="content">

<form method="post" action="./getBeerListForPage.be" style="width:350px; margin-left: auto; margin-right: auto;">
	<br>
	<h2>주문자 및 배송지 정보</h2>
	<br>이름 : <input type="text" name="o_name" size="30">
	<br>전화번호 : <input type="text" name="o_phone" size="30">
	<br>배송주소 : <input type="text" name="o_address" size="30">
	<br>배송메모 : <input type="text" name="o_memo" size="30">
	<h2>결제 수단</h2>
	<br><input type='radio' name='payment' value='네이버페이' />네이버페이
	<br><input type='radio' name='payment' value='카카오페이' />카카오페이
	<br><input type='radio' name='payment' value='토스페이' />토스페이
	<br><input type='radio' name='payment' value='신용카드' />신용카드
	<br><input type='radio' name='payment' value='무통장 입금' />무통장 입금
	<br><input type='radio' name='payment' value='휴대폰 결제' />휴대폰 결제
	<!-- <br><input type="hidden" name="actionType" value="C"> -->
	<br><button type="submit"><a>주문하기</a></button>
</form>
   
</div>

</body>



</html>