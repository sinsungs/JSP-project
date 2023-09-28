<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원관리시스템 - 데이터베이스 처리 부분</h1>
<hr>
<%
	String driverName = "org.mariadb.jdbc.Driver";	
	String url = "jdbc:mariadb://localhost/ss_db";
	String id = "root";
	String password = "1234";

	Class.forName(driverName);
	Connection con = DriverManager.getConnection(url, id, password);
	Statement stmt = con.createStatement();
	request.setCharacterEncoding("utf-8");
%>

<%
	int mem_num; 
	String mem_name;
	String mem_id;
	String mem_passwd;
	String mem_email;
	String mem_phone;
	String mem_RRN;
	int mem_class; 
	
	String sql;
	int result;
	String msg = "실행결과 : ";
	
	PreparedStatement pstmt = null;
	
	String actionType = request.getParameter("actionType");
	
	String userID;
	String userPW;

	String userID_DUMMY = "kdhong";
	String userPW_DUMMY = "1234";

	int loginState;
	

	switch( actionType ) {
	 case "LOGIN":
		
		userID = request.getParameter("userid");
	    userPW = request.getParameter("userpw");
	    
	    sql = "select * from member where mem_id = ?";
	    pstmt = con.prepareStatement(sql);
	    pstmt.setString(1, userID);
	    
	    ResultSet rs = pstmt.executeQuery();
	    
	    if(rs.next()){
	    if( userID.equals(rs.getString("mem_id"))){
	    	if( userPW.equals(rs.getString("mem_passwd"))){
	    		session.setAttribute("loginState", "login");
	    		session.setAttribute("userid", userID);
	    		session.setAttribute("userpw", userPW);
	    	}else{
	    		session.setAttribute("loginState", "errorPW");
	    		out.print("<script>alert('패스워드가 잘못되었습니다.'); location.href='./index.jsp';</script>");
	    		return;
	    	}
	    }else{
	    	session.setAttribute("loginState", "errorID");
	    	out.print("<script>alert('아이디가 잘못되었습니다.'); location.href='./index.jsp';</script>");
    		return;
	    }
	    }
	    break;
	    
	case "LOGOUT":
		session.setAttribute("userid", null);
		session.setAttribute("userpw", null);
		session.setAttribute("loginState", "logout");
		break; 
			
	
	
	case "LU":
		String u_id = request.getParameter("id");
		String u_name = request.getParameter("name");
		String u_pw= request.getParameter("passwd");
		String u_email= request.getParameter("email");
		String u_phone = request.getParameter("phone_number");
		
		
		sql = "update member set mem_name='"+u_name+"', mem_passwd='"+u_pw+"', mem_email='"+u_email+"', mem_phone='"+u_phone+"' where mem_id='"+u_id+"'";
		result = stmt.executeUpdate(sql);
		
		if(result == 1){
			out.print("<script>alert('회원정보 수정 성공했습니다.'); location.href='/kss_mvc_rental/myPage.jsp';</script>");
			return;
		}else{
			out.print("<script>alert('회원정보 수정 실패했습니다.'); location.href='/kss_mvc_rental/myPage.jsp';</script>");
		}
		return;
	}
%>

<br><a href="./index.jsp">홈으로 돌아가기</a>

<jsp:forward page="./index.jsp"/>

</body>
</html>