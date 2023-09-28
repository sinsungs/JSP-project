package kss_mvc_rental.controller.beer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kss_mvc_rental.controller.beer.Action;
import kss_mvc_rental.controller.beer.ActionForward;
import kss_mvc_rental.model.beer.*;




public class DeleteCartForIDAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int p_id = Integer.parseInt(request.getParameter("p_id"));

		BeerDAO beerDAO = new BeerDAO();
		boolean result = beerDAO.deleteCart(p_id);

		ActionForward forward = new ActionForward();

		if(result == true){
			forward.setRedirect(true);
			forward.setPath("./getCartList.be");
		}
		else {
			forward.setRedirect(false);
			forward.setPath("/com/yju/2wda/team0/view/etc/error.jsp");
		}
		return forward;
	}
}
