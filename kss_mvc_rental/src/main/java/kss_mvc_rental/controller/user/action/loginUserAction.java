package kss_mvc_rental.controller.user.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kss_mvc_rental.controller.beer.Action;
import kss_mvc_rental.controller.beer.ActionForward;
import kss_mvc_rental.model.user.UserDAO;

public class loginUserAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {


		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String userID = request.getParameter("userid");
	    String userPW = request.getParameter("userpw");
	    
		System.out.println(userID);
		
		UserDAO userDAO = new UserDAO();
//		UserDTO user = new UserDTO(userID, userPW);
		
		int result = userDAO.loginUser(userID, userPW);
		System.out.println(result);
		if (result == 1) {
			session.setAttribute("loginState", "login");
    		session.setAttribute("userid", userID);
    		session.setAttribute("userpw", userPW);
    		session.setAttribute("userRank", "user");
    		out.print("<script>alert('로그인 성공.'); location.href='./index.jsp';</script>");
		} 
		else if (result == 2) {
			session.setAttribute("loginState", "login");
    		session.setAttribute("userid", userID);
    		session.setAttribute("userpw", userPW);
    		session.setAttribute("userRank", "manager");
    		out.print("<script>alert('관리자모드 성공.'); location.href='./index.jsp';</script>");
		}
		else if (result == 0) {
			session.setAttribute("loginState", "errorPW");
    		out.print("<script>alert('패스워드가 잘못되었습니다.'); location.href='./index.jsp';</script>");
		}
		else if (result == -1) {
			session.setAttribute("loginState", "errorID");
	    	out.print("<script>alert('아이디가 잘못되었습니다.'); location.href='./index.jsp';</script>");
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		if (result == 1) {
			forward.setPath("/index.jsp");
		}
		
				

		return forward;
	
	}

}
