package kss_mvc_rental.controller.beer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

import kss_mvc_rental.controller.beer.Action;
import kss_mvc_rental.controller.beer.ActionForward;
import kss_mvc_rental.model.beer.*;

public class GetShareListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		BeerDAO beerDAO = new BeerDAO();
		ArrayList<BeerDTO> beerList;
		
	     HttpSession session = request.getSession();
		 String userID = (String) session.getAttribute("userid");
		
		beerList = beerDAO.getShareList(userID);
		request.setAttribute("beerList", beerList);
		
		System.out.println(userID);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/share.jsp");
		return forward;
	}
}
