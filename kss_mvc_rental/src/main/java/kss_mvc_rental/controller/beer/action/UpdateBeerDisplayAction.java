package kss_mvc_rental.controller.beer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

import kss_mvc_rental.controller.beer.Action;
import kss_mvc_rental.controller.beer.ActionForward;
import kss_mvc_rental.model.beer.*;

public class UpdateBeerDisplayAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

        int p_id = Integer.parseInt(request.getParameter("p_id"));

        BeerDAO beerDAO = new BeerDAO();
        BeerDTO beer = new BeerDTO();
        beer = beerDAO.getBeer(p_id);

        request.setAttribute("beer", beer);

        ActionForward forward = new ActionForward();

        forward.setRedirect(false);
        forward.setPath("/com/yju/2wda/team0/view/beer/beer_u2.jsp");
		return forward;
	}

}
