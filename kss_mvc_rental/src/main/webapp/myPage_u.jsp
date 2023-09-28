<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.sql.*" %>
    <%@ page import="kss_mvc_rental.model.user.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
<%@ include file="./header.jsp" %>
<%-- <%

String id = (String)session.getAttribute("userid");

String driverName = "org.mariadb.jdbc.Driver";
String url = "jdbc:mariadb://localhost/member_db";
String user = "root";
String pw = "1234";

Class.forName(driverName);
Connection conn = DriverManager.getConnection(url,user,pw);
Statement stmt = conn.createStatement();
request.setCharacterEncoding("utf-8");

String sql = "SELECT * FROM member WHERE mem_id = '" + id+"'";
ResultSet rs = stmt.executeQuery(sql);
rs.next();

String name = rs.getString("mem_name");
String passwd = rs.getString("mem_passwd");
String email = rs.getString("mem_email");
String phone_number = rs.getString("mem_phone");

%>
 --%>
 
 <%
	UserDTO user = (UserDTO)request.getAttribute("user");
%>


<div class="section" id="myPage">
	<div class="container">
		<div>
			<form action="./updateUserForID.be" method="post" style="width:350px; margin-left: auto; margin-right: auto;">
				<br>
				<p class="mem_title">Wear Share</p>
				<p class="mem_subTitle">회원 정보 수정</p>
				<br>
				<ul>
					<input type="hidden" name="u_num" value="<%=user.getU_num() %>">
					<li><span class="tt">이름</span> <input type="text" name="u_name" size="30" value="<%=user.getU_name() %>"></li>
					<li><span class="tt">비밀번호</span> <input type="text" name="u_pw" size="30" value="<%=user.getU_pw() %>"></li>
					<li><span class="tt">이메일</span> <input type="email" name="u_mail" size="30" value="<%=user.getU_mail() %>"></li>
					<li><span class="tt">휴대전화</span> <input type="text" name="u_phone" size="30" value="<%=user.getU_phone() %>"></li>
					<li class="btnForm">
						<input type = "hidden" name ="actionType" value = "LU">
						<button type="submit"><a>수정완료</a></button>
						<!-- <button onclick="location.href='./getUserDisplay.be';"><a>마이페이지</a></button>	 -->	
			<!-- 			<br><input type="submit" value="회원가입"> -->
						<input type="button" onclick="location.href='./getUserDisplay.be';" value="이전으로">
					</li>
				</ul>
			</form>
					
		</div>
					
				
	</div>
</div>

</body>
</html>