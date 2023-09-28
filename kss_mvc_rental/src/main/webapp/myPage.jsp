<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="kss_mvc_rental.model.user.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Wear Share</title>
</head>
<body>
<%
	UserDTO user = (UserDTO)request.getAttribute("user");
%>
	<%@ include file="/header.jsp" %>
		
	
	<div class="section" id="myPage">
		<div class="container">
			<div style="width:350px; margin-left: auto; margin-right: auto;">
				<br>
				<p class="mem_title">Wear Share</p>
				<p class="mem_subTitle"> 마이페이지입니다.</p>
				<br>
				<ul>
					<li><span class="tt">이름</span> <%=user.getU_name() %></li>
					<li><span class="tt">아이디</span> <%=user.getU_id() %></li>
					<li><span class="tt">비밀번호</span> <%=user.getU_pw() %></li>
					<li><span class="tt">이메일</span> <%=user.getU_mail() %></li>
					<li><span class="tt">휴대전화</span> <%=user.getU_phone() %></li>
					<li><span class="tt">주민번호</span> <%=user.getU_rrn() %></li>
					<%-- <li><span class="tt">직급</span> <%=user.getU_name() %></li> --%>
					<li class="btnForm">
						<button class="updateBtn" onclick="location.href='./updateUserDisplay.be';"><a>회원정보 수정</a></button>
						<button class="deleteBtn" onclick="deleteId();"><a>회원 탈퇴</a></button>
					</li>
				</ul>
			</div>
		</div>
	</div>	

	
	<script>
		function deleteId(){
			let deleteChk = confirm("정말 삭제하시겠습니까?!");
			
			if(deleteChk){
				location.href='./deleteUserForID.be ';
			}else{
				return false;
			}
		}
	</script>
</body>
</html>