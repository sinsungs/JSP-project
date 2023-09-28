package kss_mvc_rental.controller.beer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

import kss_mvc_rental.controller.beer.Action;
import kss_mvc_rental.controller.beer.ActionForward;
import kss_mvc_rental.model.beer.*;

public class AdjustBPIAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String displayRecordCnt = request.getParameter("displayRecordCnt");
		int drc = (displayRecordCnt == null)?10:Integer.parseInt(displayRecordCnt);
		
		HttpSession session = request.getSession();
		BeerPageInfoVO bpiVO = (BeerPageInfoVO)session.getAttribute("beerPageInfoVO");

		bpiVO.setLimitCnt(drc);
		bpiVO.setCurrentPageNo(0);
		bpiVO.adjPageInfo();

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/index.jsp");
		return forward;
	}
}
