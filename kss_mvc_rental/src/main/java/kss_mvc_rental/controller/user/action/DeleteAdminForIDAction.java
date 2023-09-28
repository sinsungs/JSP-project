package kss_mvc_rental.controller.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kss_mvc_rental.controller.beer.Action;
import kss_mvc_rental.controller.beer.ActionForward;
import kss_mvc_rental.model.user.*;

public class DeleteAdminForIDAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
//		int p_id = Integer.parseInt(request.getParameter("p_id"));
		
		HttpSession session = request.getSession();
//		String userID = (String) session.getAttribute("userid");
		String userID = (String) request.getParameter("u_id");

		UserDAO userDAO = new UserDAO();
		boolean result = userDAO.deleteUser(userID);

		ActionForward forward = new ActionForward();

		if(result == true){
			forward.setRedirect(false);
			forward.setPath("./updateUserListDisplay.be");
			session.invalidate();
			
		}
		else {
			forward.setRedirect(false);
			forward.setPath("/com/yju/2wda/team0/view/etc/error.jsp");
		}
		return forward;
	}
}
