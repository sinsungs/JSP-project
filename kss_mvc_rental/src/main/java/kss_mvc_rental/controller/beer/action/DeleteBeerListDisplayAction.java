package kss_mvc_rental.controller.beer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

import kss_mvc_rental.controller.beer.Action;
import kss_mvc_rental.controller.beer.ActionForward;
import kss_mvc_rental.model.beer.*;

public class DeleteBeerListDisplayAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String currentPageNo = request.getParameter("currentPageNo");
        int cpn = (currentPageNo == null)?0:Integer.parseInt(currentPageNo);

        HttpSession session = request.getSession();
        BeerPageInfoVO bpiVO = (BeerPageInfoVO)session.getAttribute("beerPageInfoVO");

        BeerDAO beerDAO = new BeerDAO();
        ArrayList<BeerDTO> beerList;

        bpiVO.setCurrentPageNo(cpn);
        bpiVO.adjPageInfo();

        beerList = beerDAO.getBeerListForPage(bpiVO);
        request.setAttribute("beerList", beerList);

        ActionForward forward = new ActionForward();
        forward.setRedirect(false);
        forward.setPath("/com/yju/2wda/team0/view/beer/beer_d.jsp");
		return forward;
	}

}
