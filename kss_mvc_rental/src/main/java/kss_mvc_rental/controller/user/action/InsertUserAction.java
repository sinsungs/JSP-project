package kss_mvc_rental.controller.user.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import java.util.Enumeration;



import java.util.*;
import kss_mvc_rental.controller.beer.Action;
import kss_mvc_rental.controller.beer.ActionForward;
import kss_mvc_rental.model.beer.*;
import kss_mvc_rental.model.user.UserDAO;
import kss_mvc_rental.model.user.UserDTO;


public class InsertUserAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		UserDAO userDAO = new UserDAO();
		UserDTO user = new UserDTO();
		user.setU_name(request.getParameter("u_name"));
		user.setU_id(request.getParameter("u_id"));
		user.setU_pw(request.getParameter("u_pw"));
		user.setU_mail(request.getParameter("u_mail"));
		user.setU_phone(request.getParameter("u_phone"));
		user.setU_rrn(request.getParameter("u_rrn"));
		
		boolean result = userDAO.insertUser(user);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		if (result == true) {
			forward.setPath("/index.jsp");
		} else {
			forward.setPath("/com/yju/2wda/team0/view/etc/error.jsp");
		}
		return forward;
	}
}