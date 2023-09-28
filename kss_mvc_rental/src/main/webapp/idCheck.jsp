<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
String driverName = "org.mariadb.jdbc.Driver";
String url = "jdbc:mariadb://localhost/kss05_db";
String user = "root";
String password = "1234";

Class.forName(driverName);
Connection con = DriverManager.getConnection(url, user, password);
Statement stmt = con.createStatement();
request.setCharacterEncoding("utf-8");

String sql;

String uID = request.getParameter("userID");
sql = "SELECT * FROM user where u_id='"+uID+"'";
ResultSet uIDChk = stmt.executeQuery(sql);
if(uIDChk.next()){
	out.print(0);
}else{
	out.print(1);
}
%>