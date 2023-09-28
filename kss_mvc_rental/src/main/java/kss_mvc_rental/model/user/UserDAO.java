package kss_mvc_rental.model.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kss_mvc_rental.model.beer.BeerDTO;

public class UserDAO {

	
	private PreparedStatement pstmt = null;
	private Connection con = null;

	Context init = null; // 컨텍스트 객체 변수
	DataSource ds = null; // 데이터소스 객체 변수

	ResultSet rs = null; // 쿼리결과셋 객체 변수
	
	int loginState;
	String id;
	String pw;
	
	public UserDAO() {
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
	
	
	public boolean insertUser(UserDTO user) {
		boolean success = false;
//		dbConnect();
		
		String sql = "insert into user(u_num, u_name, u_id, u_pw, ";
		sql += "u_mail, u_phone, u_rrn)";
		sql += "values(?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user.getU_num());
			pstmt.setString(2, user.getU_name());
			pstmt.setString(3, user.getU_id());
			pstmt.setString(4, user.getU_pw());
			pstmt.setString(5, user.getU_mail());
			pstmt.setString(6, user.getU_phone());
			pstmt.setString(7, user.getU_rrn());

			pstmt.executeUpdate();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
			return success;
		} finally {
			disConnect();
		}
		return success;
	}
	
	public int loginUser(String userID, String userPW) {
		boolean success = false;
//		dbConnect();
		
	    String sql = "select * from user where u_id = ?";
	    
	    try {
	    	pstmt = con.prepareStatement(sql);
		    pstmt.setString(1, userID);
		    System.out.println(userID);
		    ResultSet rs = pstmt.executeQuery();
		    
//		    UserDTO user = new UserDTO();
//		    
		    
		    if(rs.next()) {
		    	if(rs.getString("u_pw").equals(userPW)) {
		    		System.out.println(rs.getString("u_class"));
		    		if(rs.getString("u_class").equals("manager")) {	
		    			return 2; // 관리자 로그인 성공 
		    		}
		    		return 1; // 로그인 성공  		
		    	}
		    	else
		    		return 0; // 비밀번호 불일치
		    }
		    return -1; // 아이디 없음 
		    
	    } catch (SQLException e) {
			e.printStackTrace();

		} finally {
			disConnect();
		}
		return -2; //데이터 베이스 오류 
	}
	
	
	// 주 키 b_id의 레코드를 반환하는 메서드 - R
	public UserDTO getUser(String userID) {
//		dbConnect();
		
		String SQL = "select * from user where u_id = ?";
		UserDTO user = new UserDTO();
		
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, userID);
			ResultSet rs = pstmt.executeQuery();
			rs.next();			
			user.setU_num(rs.getInt("u_num"));
			user.setU_name(rs.getString("u_name"));
			user.setU_id(rs.getString("u_id"));
			user.setU_pw(rs.getString("u_pw"));
			user.setU_mail(rs.getString("u_mail"));
			user.setU_phone(rs.getString("u_phone"));
			user.setU_rrn(rs.getString("u_rrn"));
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disConnect();
		}
		return user;
	}

	
	//  모든 유저 레코드를 반환 메서드 - R
	public ArrayList<UserDTO> getUserList() {
//		dbConnect();
		
		ArrayList<UserDTO> list = new ArrayList<UserDTO>();

		String SQL = "select * from user";
		try {
			pstmt = con.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				UserDTO user = new UserDTO();
				user.setU_num(rs.getInt("u_num"));
				user.setU_name(rs.getString("u_name"));
				user.setU_id(rs.getString("u_id"));
				user.setU_pw(rs.getString("u_pw"));
				user.setU_mail(rs.getString("u_mail"));
				user.setU_phone(rs.getString("u_phone"));
				user.setU_rrn(rs.getString("u_rrn"));
				user.setU_class(rs.getString("u_class"));
				list.add(user);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}
	
	// 데이터 갱신을 위한 메서드 - U
	public boolean updateUser(UserDTO user, String userID) {
		
		boolean success = false;
//		dbConnect();
		String sql = "update user set u_name=?, u_pw=?, u_mail=?, u_phone=? where u_id=? ";

		try {
			pstmt = con.prepareStatement(sql);
			
			// 인자로 받은 BeerVO 객체를 이용해 사용자가 수정한 값을 가져와 SQL문 완성
	
			pstmt.setString(1, user.getU_name());
			pstmt.setString(2, user.getU_pw());
			pstmt.setString(3, user.getU_mail());
			pstmt.setString(4, user.getU_phone());
			pstmt.setString(5, userID);

			int rowUdt = pstmt.executeUpdate();
			// System.out.println(rowUdt);
			if (rowUdt == 1)
				success = true;
		} catch (SQLException e) {
			e.printStackTrace();
			return success;
		} finally {
			disConnect();
		}
		return success;
	}
	
	// 게시물 삭제를 위한 메서드 - D
	public boolean deleteUser(String userID) {
		boolean success = false;
//		dbConnect();
		String sql = "delete from user where u_id=?";
		try {
			pstmt = con.prepareStatement(sql);
			// 인자로 받은 주 키인 id 값을 이용해 삭제
			pstmt.setString(1, userID);
			pstmt.executeUpdate();
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
