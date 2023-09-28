package kss_mvc_rental.model.beer;

import java.util.ArrayList;
import java.sql.*;
import javax.sql.*;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import java.util.Enumeration;

import kss_mvc_rental.model.beer.BeerDTO;

import javax.naming.*;

public class BeerDAO {

//	private final static String driverName = "org.mariadb.jdbc.Driver";
//	private final static String url = "jdbc:mariadb://localhost/kss05_db";
//	private final static String user = "root";
//	private final static String passwd = "1234";

	private PreparedStatement pstmt = null;
	private Connection con = null;

	Context init = null; // 컨텍스트 객체 변수
	DataSource ds = null; // 데이터소스 객체 변수

	ResultSet rs = null; // 쿼리결과셋 객체 변수

	// JDBC 드라이버 로드 메소드
//	public void jdbcDriverLoad() {
//		try {
//			Class.forName(driverName);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	// 데이터베이스 연결 메소드
//	public void dbConnect() {
//		try {
//			con = DriverManager.getConnection(url,user,passwd);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public BeerDAO() {
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

	
	// 검색한 모든 레코드를 반환 메서드 - R - search
	public ArrayList<BeerDTO> searchBeerList(String p_name) {
//		dbConnect();
		ArrayList<BeerDTO> list = new ArrayList<BeerDTO>();

		String SQL = "select * from product where p_name like ?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, "%"+p_name+"%");
			ResultSet rs = pstmt.executeQuery();

			
			while (rs.next()) {
				BeerDTO beer = new BeerDTO();
				beer.setP_id(rs.getInt("p_id"));
				beer.setP_category(rs.getString("p_category"));
				beer.setP_store(rs.getString("p_store"));
				beer.setP_name(rs.getString("p_name"));
				beer.setP_price(rs.getInt("p_price"));
				beer.setP_state(rs.getString("p_state"));
				beer.setP_like(rs.getInt("p_like"));
				beer.setP_image(rs.getString("p_image"));
				list.add(beer);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}
	
	
	// 게시판의 모든 레코드를 반환 메서드 - R
	public ArrayList<BeerDTO> getBeerList() {
//		dbConnect();
		ArrayList<BeerDTO> list = new ArrayList<BeerDTO>();

		String SQL = "select * from product";
		try {
			pstmt = con.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				BeerDTO beer = new BeerDTO();
				beer.setP_id(rs.getInt("p_id"));
				beer.setP_category(rs.getString("p_category"));
				beer.setP_store(rs.getString("p_store"));
				beer.setP_name(rs.getString("p_name"));
				beer.setP_price(rs.getInt("p_price"));
				beer.setP_state(rs.getString("p_state"));
				beer.setP_like(rs.getInt("p_like"));
				beer.setP_image(rs.getString("p_image"));
				list.add(beer);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}


	// 장바구니의 담긴 반환 메서드 - R
		public ArrayList<BeerDTO> getCartList(String userID) {
//			dbConnect();
			ArrayList<BeerDTO> list = new ArrayList<BeerDTO>();

			String SQL = "select * from cart where u_id = ?";
			try {
				pstmt = con.prepareStatement(SQL);
				pstmt.setString(1, userID);
				System.out.println(SQL);
				
				ResultSet rs = pstmt.executeQuery();
				
				while (rs.next()) {
					BeerDTO beer = new BeerDTO();
					beer.setP_id(rs.getInt("c_id"));
					beer.setP_category(rs.getString("c_category"));
					beer.setP_store(rs.getString("c_store"));
					beer.setP_name(rs.getString("c_name"));
					beer.setP_price(rs.getInt("c_price"));
					beer.setP_state(rs.getString("c_state"));
					beer.setP_like(rs.getInt("c_like"));
					beer.setP_image(rs.getString("c_image"));
					list.add(beer);
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disConnect();
			}
			return list;
		}
		
		// share 담긴 반환 메서드 - R
		public ArrayList<BeerDTO> getShareList(String userID) {
//			dbConnect();
			ArrayList<BeerDTO> list = new ArrayList<BeerDTO>();

			String SQL = "select * from share where u_id = ?";
			try {
				pstmt = con.prepareStatement(SQL);
				pstmt.setString(1, userID);
				System.out.println(SQL);
				
				ResultSet rs = pstmt.executeQuery();
				
				while (rs.next()) {
					BeerDTO beer = new BeerDTO();
					beer.setP_id(rs.getInt("s_id"));
					beer.setP_category(rs.getString("s_category"));
					beer.setP_store(rs.getString("s_store"));
					beer.setP_name(rs.getString("s_name"));
					beer.setP_price(rs.getInt("s_price"));
					beer.setP_state(rs.getString("s_state"));
					beer.setP_like(rs.getInt("s_like"));
					beer.setP_image(rs.getString("s_image"));
					beer.setP_time(rs.getString("s_time"));
					beer.setP_endtime(rs.getString("s_endtime"));					
					list.add(beer);
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disConnect();
			}
			return list;
		}
	
	

	// 종류별 조회 r_part
	public ArrayList<BeerDTO> getBeerListForPart(BeerPageInfoVO bpiVO, String search, String Part) {
//			dbConnect();
		ArrayList<BeerDTO> list = new ArrayList<BeerDTO>();

		String SQL = "select * from product where " + Part + "='" + search + "' ORDER BY b_id limit ?, ?";
		System.out.println(SQL);
//			String SQL = "SELECT * FROM beer where b_"+cate+"='"+searchVal+"' ORDER BY b_id desc limit ?, ?";
		String SQL2 = "select count(*) from product where " + Part + "='" + search + "'";

		ResultSet rs;

		try {
			pstmt = con.prepareStatement(SQL2);

			rs = pstmt.executeQuery();
			System.out.print(Part);
			System.out.print(search);
			while (rs.next()) {
				bpiVO.setRecordCnt(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		bpiVO.adjPageInfo();

		try {
			pstmt = con.prepareStatement(SQL);

			pstmt.setInt(1, bpiVO.getStartRecord());
			pstmt.setInt(2, bpiVO.getLimitCnt());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				BeerDTO beer = new BeerDTO();
				beer.setP_id(rs.getInt("p_id"));
				beer.setP_category(rs.getString("p_category"));
				beer.setP_store(rs.getString("p_store"));
				beer.setP_name(rs.getString("p_name"));
				beer.setP_price(rs.getInt("p_price"));
				beer.setP_state(rs.getString("p_state"));
				beer.setP_like(rs.getInt("p_like"));
				beer.setP_image(rs.getString("p_image"));
				list.add(beer);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return list;
	}

	// 게시판의 현재 페이지 레코드를 반환 메서드 - R4
	public ArrayList<BeerDTO> getBeerListForPage(BeerPageInfoVO bpiVO) {
//		dbConnect();
		ArrayList<BeerDTO> list = new ArrayList<BeerDTO>();

		String SQL = "select * from product ORDER BY p_id limit ?, ?";
		String SQL2 = "select count(*) from product";

		ResultSet rs;

		try {
			pstmt = con.prepareStatement(SQL2);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				bpiVO.setRecordCnt(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		bpiVO.adjPageInfo();

		try {
			pstmt = con.prepareStatement(SQL);

			pstmt.setInt(1, bpiVO.getStartRecord());
			pstmt.setInt(2, bpiVO.getLimitCnt());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				BeerDTO beer = new BeerDTO();
				beer.setP_id(rs.getInt("p_id"));
				beer.setP_category(rs.getString("p_category"));
				beer.setP_store(rs.getString("p_store"));
				beer.setP_name(rs.getString("p_name"));
				beer.setP_price(rs.getInt("p_price"));
				beer.setP_state(rs.getString("p_state"));
				beer.setP_like(rs.getInt("p_like"));
				beer.setP_image(rs.getString("p_image"));
				list.add(beer);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return list;
	}

	// 주 키 b_id의 레코드를 반환하는 메서드 - R
	public BeerDTO getBeer(int p_id) {
//		dbConnect();
		String SQL = "select * from product where p_id = ?";
		BeerDTO beer = new BeerDTO();
		
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, p_id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();			
//			beer.setP_id(rs.getInt("p_id"));
			beer.setP_category(rs.getString("p_category"));
			beer.setP_store(rs.getString("p_store"));
			beer.setP_name(rs.getString("p_name"));
			beer.setP_price(rs.getInt("p_price"));
			beer.setP_state(rs.getString("p_state"));
			beer.setP_like(rs.getInt("p_like"));
			beer.setP_image(rs.getString("p_image"));
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disConnect();
		}
		return beer;
	}


		// 장바구니 추가 메서드 - Cart
		public boolean insertCartForID(BeerDTO beer, String userID) {
			boolean success = false;
			dbConnect();
			String sql = "insert into cart(c_id, c_category, c_store, c_name, ";
			sql += "c_price, c_state, c_like, c_image, u_id)";
			sql += "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, beer.getP_id());
				pstmt.setString(2, beer.getP_category());
				pstmt.setString(3, beer.getP_store());
				pstmt.setString(4, beer.getP_name());
				pstmt.setInt(5, beer.getP_price());
				pstmt.setString(6, beer.getP_state());
				pstmt.setInt(7, beer.getP_like());
				pstmt.setString(8, beer.getP_image());
				pstmt.setString(9, userID);
				
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
		
		// Share 추가 메서드 - Share
		public boolean insertShareForID(BeerDTO beer, String userID, String time, String endtime) {
			boolean success = false;
			dbConnect();
			String sql = "insert into share(s_id, s_category, s_store, s_name, ";
			sql += "s_price, s_state, s_like, s_image, u_id, s_time, s_endtime)";
			sql += "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, beer.getP_id());
				pstmt.setString(2, beer.getP_category());
				pstmt.setString(3, beer.getP_store());
				pstmt.setString(4, beer.getP_name());
				pstmt.setInt(5, beer.getP_price());
				pstmt.setString(6, beer.getP_state());
				pstmt.setInt(7, beer.getP_like());
				pstmt.setString(8, beer.getP_image());
				pstmt.setString(9, userID);
				pstmt.setString(10, time);
				pstmt.setString(11, endtime);
				
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
	

	// 게시물 등록 메서드 - C
	public boolean insertBeer(BeerDTO beer) {
		boolean success = false;
//		dbConnect();
		String sql = "insert into product(p_id, p_category, p_store, p_name, ";
		sql += "p_price, p_state, p_like, p_image)";
		sql += "values(?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, beer.getP_id());
			pstmt.setString(2, beer.getP_category());
			pstmt.setString(3, beer.getP_store());
			pstmt.setString(4, beer.getP_name());
			pstmt.setInt(5, beer.getP_price());
			pstmt.setString(6, beer.getP_state());
			pstmt.setInt(7, beer.getP_like());
			pstmt.setString(8, beer.getP_image());

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
	

		
	
	// 데이터 갱신을 위한 메서드 - U
	public boolean updateBeer(BeerDTO beer) {
		
		boolean success = false;
//		dbConnect();
		String sql = "update product set p_category=?, p_store=?, p_name=?,  ";
		sql += "p_price=?, p_state=?, p_like=?, ";
		sql += "p_image=? where p_id=?";
		try {
			pstmt = con.prepareStatement(sql);
			// 인자로 받은 BeerVO 객체를 이용해 사용자가 수정한 값을 가져와 SQL문 완성
			pstmt.setString(1, beer.getP_category());
			pstmt.setString(2, beer.getP_store());
			pstmt.setString(3, beer.getP_name());
			pstmt.setInt(4, beer.getP_price());
			pstmt.setString(5, beer.getP_state());
			pstmt.setInt(6, beer.getP_like());
			pstmt.setString(7, beer.getP_image());
			pstmt.setInt(8, beer.getP_id());

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
	public boolean deleteBeer(int p_id) {
		boolean success = false;
//		dbConnect();
		String sql = "delete from product where p_id=?";
		try {
			pstmt = con.prepareStatement(sql);
			// 인자로 받은 주 키인 id 값을 이용해 삭제
			pstmt.setInt(1, p_id);
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
	
	// cart 삭제를 위한 메서드 - D
	public boolean deleteCart(int p_id) {
		boolean success = false;
//		dbConnect();
		String sql = "delete from cart where c_id=?";
		try {
			pstmt = con.prepareStatement(sql);
			// 인자로 받은 주 키인 id 값을 이용해 삭제
			pstmt.setInt(1, p_id);
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
	
	// share 삭제를 위한 메서드 - D
	public boolean deleteShare(int p_id) {
		boolean success = false;
//		dbConnect();
		String sql = "delete from share where s_id=?";
		try {
			pstmt = con.prepareStatement(sql);
			// 인자로 받은 주 키인 id 값을 이용해 삭제
			pstmt.setInt(1, p_id);
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
