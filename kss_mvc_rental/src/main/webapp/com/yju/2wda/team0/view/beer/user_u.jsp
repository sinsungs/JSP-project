<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="kss_mvc_rental.model.user.*" %>
<%@ page import="java.util.*" %>

    <link rel="stylesheet" href="<%= workDir %>/css/style.css">
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이쇼핑몰(KDH17) - 맥주자료조회(R)</title>
</head>
<body>

<%@ include file="/header.jsp" %>


<%
	UserDTO user;
	ArrayList<UserDTO> userList;
	
	userList = (ArrayList<UserDTO>)request.getAttribute("userList");
%>

<div style="width:700px; margin-left: auto; margin-right: auto;">

<table border="1">
		<thead>
			<tr>
				<th>회원등급</th>
				<th>이름</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이메일</th>
				<th>전화번호</th>


				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>		
		<tbody>
		
<%
	for(int i=0; i < userList.size(); i++) {
		user = userList.get(i);
%>		
			<tr>
				<td><%=user.getU_class() %></td>
				<td><%=user.getU_name() %></td>
				<td><%=user.getU_id() %></td>
				<td><%=user.getU_pw() %></td>
				<td><%=user.getU_mail() %></td>
				<td><%=user.getU_phone() %></td>


				<td><a href="./updateAdminDisplay.be?u_id=<%=user.getU_id()%>">UPDATE</a></td>
				<td><a href="./deleteAdminForID.be?u_id=<%=user.getU_id()%>">DELETE</a></td>
			</tr>
<%
	}
%>
		</tbody>
	</table>
	<br><a href="<%=rootDir %>/index.jsp">홈으로 돌아가기</a>
</div>

	         

</body>
</html>