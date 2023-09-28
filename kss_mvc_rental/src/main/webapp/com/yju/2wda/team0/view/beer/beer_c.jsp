<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이쇼핑몰(KDH17) - 맥주자료입력(C)</title>
</head>
<body>

<%@ include file="/header.jsp" %>
<div class="content">
<form method="post" action="./insertUser.be" style="width:350px; margin-left: auto; margin-right: auto;">
	<h1>회원 가입</h1>
	<br>이름 : <input type="text" name="u_name" size="30">
	<br>아이디 : <input type="text" name="u_id" size="30">
	<br>비밀번호 : <input type="text" name="u_pw" size="30">
	<br>이메일 : <input type="text" name="u_mail" size="30">
	<br>휴대번호 : <input type="text" name="u_phone" size="30">
	<br>주민번호 : <input type="text" name="u_rrn" size="30">
<!-- 	<br><input type="hidden" name="actionType" value="C"> -->
	<br><input type="submit" value="회원가입">
</form>

</div>

</body>
</html>