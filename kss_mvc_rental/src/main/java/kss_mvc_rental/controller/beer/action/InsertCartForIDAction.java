package kss_mvc_rental.controller.beer.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import kss_mvc_rental.controller.beer.Action;
import kss_mvc_rental.controller.beer.ActionForward;
import kss_mvc_rental.model.beer.*;

public class InsertCartForIDAction implements Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		 int p_id = Integer.parseInt(request.getParameter("p_id"));
	
		 BeerDAO beerDAO = new BeerDAO();
		 BeerDTO beer = new BeerDTO();
	     beer = beerDAO.getBeer(p_id);
		 // p_id에 해당하는 객체를 얻음 
	     
	     request.setAttribute("beer", beer);
	     
	     HttpSession session = request.getSession();
		 String userID = (String) session.getAttribute("userid");
	     
		boolean result = beerDAO.insertCartForID(beer, userID);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		if (result == true) {
			forward.setPath("/index.jsp");
		} else {
			forward.setPath("/com/yju/2wda/team0/view/etc/error.jsp");
		}
		return forward;
	}

}
