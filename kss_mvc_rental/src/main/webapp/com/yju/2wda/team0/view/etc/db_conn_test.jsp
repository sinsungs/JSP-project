<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터베이스 연결 테스트 JSP페이지</title>
</head>
<body>
<h1>DBCP 연결 테스트 - With MariaDB</h1>
<hr>
<%
	Connection con = null;

	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc_mariadb");
		con = ds.getConnection();
		
		out.println("<h3>DB연결 성공!!!");
	}catch(Exception e){
		out.println("<h3>DB연결 실패!!!");
		e.printStackTrace();
	}finally{
		if( con != null )
			con.close();
	}
%>
</body>
</html>