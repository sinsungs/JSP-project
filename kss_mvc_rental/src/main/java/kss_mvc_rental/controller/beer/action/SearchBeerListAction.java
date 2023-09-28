package kss_mvc_rental.controller.beer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

import kss_mvc_rental.controller.beer.Action;
import kss_mvc_rental.controller.beer.ActionForward;
import kss_mvc_rental.model.beer.*;

public class SearchBeerListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		String p_name = request.getParameter("search");
		
		System.out.println(p_name);
		
		BeerDAO beerDAO = new BeerDAO();
		ArrayList<BeerDTO> beerList;
		
		beerList = beerDAO.searchBeerList(p_name);
		request.setAttribute("beerList", beerList);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/search.jsp");
		return forward;
	}
}
