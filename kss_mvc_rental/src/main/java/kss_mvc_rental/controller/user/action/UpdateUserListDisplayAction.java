package kss_mvc_rental.controller.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

import kss_mvc_rental.controller.beer.Action;
import kss_mvc_rental.controller.beer.ActionForward;
import kss_mvc_rental.model.user.*;

public class UpdateUserListDisplayAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		UserDAO userDAO = new UserDAO();
		ArrayList<UserDTO> userList;
		
		userList = userDAO.getUserList();
		request.setAttribute("userList", userList);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/com/yju/2wda/team0/view/beer/user_u.jsp");
		return forward;
	}
}
