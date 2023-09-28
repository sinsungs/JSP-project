package kss_mvc_rental.controller.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kss_mvc_rental.controller.beer.Action;
import kss_mvc_rental.controller.beer.ActionForward;
import kss_mvc_rental.model.user.UserDAO;
import kss_mvc_rental.model.user.UserDTO;

public class UpdateAdminDisplayAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

			
//	        int p_id = Itnteger.parseInt(request.getParameer("p_id"));
			
			HttpSession session = request.getSession();
//			String userID = (String) session.getAttribute("userid");
			String userID = (String) request.getParameter("u_id");

	        UserDAO userDAO = new UserDAO();
	        UserDTO user = new UserDTO();
	        user = userDAO.getUser(userID);

	        request.setAttribute("user", user);

	        ActionForward forward = new ActionForward();

	        forward.setRedirect(false);
	        forward.setPath("/adminPage_u.jsp");
			return forward;
		}


}
