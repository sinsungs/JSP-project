package kss_mvc_rental.controller.beer.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import kss_mvc_rental.controller.beer.Action;
import kss_mvc_rental.controller.beer.ActionForward;
import kss_mvc_rental.model.beer.*;

public class UpdateBeerForIDAction implements Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		BeerDTO beer = new BeerDTO();
		beer.setP_id(Integer.parseInt(request.getParameter("p_id")));
		beer.setP_category(request.getParameter("p_category"));
		beer.setP_store(request.getParameter("p_store"));
		beer.setP_name(request.getParameter("p_name"));
		beer.setP_price(Integer.parseInt(request.getParameter("p_price")));
		beer.setP_state(request.getParameter("p_state"));
		beer.setP_like(Integer.parseInt(request.getParameter("p_like")));
		beer.setP_image(request.getParameter("p_image"));
        BeerDAO beerDAO = new BeerDAO();
		boolean result = beerDAO.updateBeer(beer);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		if (result == true) {
			forward.setPath("./getBeerListForPage.be");
		} else {
			forward.setPath("/com/yju/2wda/team0/view/etc/error.jsp");
		}
		return forward;
	}

}
