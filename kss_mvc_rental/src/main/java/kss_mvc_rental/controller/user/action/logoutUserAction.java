package kss_mvc_rental.controller.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kss_mvc_rental.controller.beer.Action;
import kss_mvc_rental.controller.beer.ActionForward;

public class logoutUserAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/index.jsp");
		return forward;
	}

}
