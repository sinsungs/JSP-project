package kss_mvc_rental.controller.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

import kss_mvc_rental.controller.beer.Action;
import kss_mvc_rental.controller.beer.ActionForward;
import kss_mvc_rental.model.user.*;

public class GetUserDisplayAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

//        int p_id = Integer.parseInt(request.getParameter("p_id"));
		
		HttpSession session = request.getSession();
		String userID = (String) session.getAttribute("userid");

        UserDAO userDAO = new UserDAO();
        UserDTO user = new UserDTO();
        user = userDAO.getUser(userID);

        request.setAttribute("user", user);

        ActionForward forward = new ActionForward();

        forward.setRedirect(false);
        forward.setPath("/myPage.jsp");
		return forward;
	}

}
