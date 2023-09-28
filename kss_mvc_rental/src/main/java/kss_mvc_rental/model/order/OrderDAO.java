package kss_mvc_rental.model.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kss_mvc_rental.model.order.OrderDTO;
import kss_mvc_rental.model.user.UserDTO;

public class OrderDAO {

	
	private PreparedStatement pstmt = null;
	private Connection con = null;

	Context init = null; // 컨텍스트 객체 변수
	DataSource ds = null; // 데이터소스 객체 변수

	ResultSet rs = null; // 쿼리결과셋 객체 변수
	
	int loginState;
	String id;
	String pw;
	
	public OrderDAO() {
		super();
		dbConnect();
	}
	
	public void dbConnect() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc_mariadb");
			con = ds.getConnection();

			System.out.println("DB연결 성공!!!");
		} catch (Exception e) {
			System.out.println("DB연결 실패!!!");
			e.printStackTrace();
		}
	}

	// 데이터베이스 연결 해제 메소드
	public void disConnect() {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// 쿼리결과셋 객체 해제 부분 추가
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean insertOrder(OrderDTO order) {
		boolean success = false;
//		dbConnect();
		
		String sql = "insert into order(o_id, o_name, o_phone, o_address, ";
		sql += "o_memo, o_payment)";
		sql += "values(?, ?, ?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, order.getO_id());
			pstmt.setString(2, order.getO_name());
			pstmt.setString(3, order.getO_phone());
			pstmt.setString(4, order.getO_address());
			pstmt.setString(5, order.getO_memo());
			pstmt.setString(6, order.getO_payment());

			pstmt.executeUpdate();
			System.out.println(sql);
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
			return success;
		} finally {
			disConnect();
		}
		return success;
	}

}

























