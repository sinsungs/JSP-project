package kss_mvc_rental.controller.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import kss_mvc_rental.controller.beer.Action;
import kss_mvc_rental.controller.beer.ActionForward;
import kss_mvc_rental.model.user.*;

public class UpdateAdminForIDAction implements Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
//		String userID = (String) session.getAttribute("userid");
		String userID = (String) request.getParameter("u_id");

		UserDTO user = new UserDTO();
		
		user.setU_name(request.getParameter("u_name"));
		user.setU_pw(request.getParameter("u_pw"));
		user.setU_mail(request.getParameter("u_mail"));
		user.setU_phone(request.getParameter("u_phone"));


        UserDAO userDAO = new UserDAO();
		boolean result = userDAO.updateUser(user, userID);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		if (result == true) {
			forward.setPath("./updateUserListDisplay.be");
		} else {
			forward.setPath("/com/yju/2wda/team0/view/etc/error.jsp");
		}
		return forward;
	}

}
