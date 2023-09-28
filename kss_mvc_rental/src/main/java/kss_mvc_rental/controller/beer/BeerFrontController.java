package kss_mvc_rental.controller.beer;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;


import kss_mvc_rental.model.beer.*;
import kss_mvc_rental.controller.beer.action.*;
import kss_mvc_rental.controller.order.action.InsertOrderAction;
import kss_mvc_rental.controller.user.action.*;

import kss_mvc_rental.controller.beer.*;

public class BeerFrontController extends HttpServlet implements Servlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		
		command = command.substring(command.lastIndexOf("/"));
		System.out.println("command : " + command);
		
		BeerPageInfoVO bpiVO;
		HttpSession session = request.getSession();
		
		if( session.getAttribute("beerPageInfoVO") == null) {
			bpiVO = new BeerPageInfoVO();
			session.setAttribute("beerPageInfoVO", bpiVO);
		}
		else {
			bpiVO = (BeerPageInfoVO)session.getAttribute("beerPageInfoVO");
		}
		
		ActionForward forward = null;
		Action action = null;
				
		switch( command ) {

//		product 컨트롤러
		case "/insertBeer.be":
			action = new InsertBeerAction();
			break;
		case "/getBeerList.be":
			action = new GetBeerListAction();
			break;
		case "/getBeerListForPage.be":
			action = new GetBeerListForPageAction();
			break;
		case "/adjustBPI.be":
			action = new AdjustBPIAction();
			break;
		case "/deleteBeerForID.be":
			action = new DeleteBeerForIDAction();
			break;
		case "/deleteBeerListDisplay.be":
			action = new DeleteBeerListDisplayAction();
			break;
		case "/updateBeerListDisplay.be":
			action = new UpdateBeerListDisplayAction();
			break;
		case "/updateBeerDisplay.be":
			action = new UpdateBeerDisplayAction();
			break;
		case "/updateBeerForID.be":
			action = new UpdateBeerForIDAction();
			break;
			
		case "/searchBeerList.be":
			action = new SearchBeerListAction();
			break;
			
//			cart 컨트롤러
		case "/insertCartForID.be":
			action = new InsertCartForIDAction();
			break;
		case "/getCartList.be":
			action = new GetCartListAction();
			break;
		case "/deleteCartForID.be":
			action = new DeleteCartForIDAction();
			break;
			
//			cart 컨트롤러
		case "/insertShareForID.be":
			action = new InsertShareForIDAction();
			break;
		case "/getShareList.be":
			action = new GetShareListAction();
			break;
		case "/deleteShareForID.be":
			action = new DeleteShareForIDAction();
			break;
			
		
//			주문 컨트롤러
		case "/insertOrder.be":
			action = new InsertOrderAction();
			break;
			
			
//			회원가입, 로그인 컨트롤러		
		case "/insertUser.be":
			action = new InsertUserAction();
			break;
		case "/loginUser.be":
			action = new loginUserAction();
			break;
		case "/logoutUser.be":
			action = new logoutUserAction();
			break;
			
			
//			회원정보 수정 삭제 컨트롤러		
		case "/getUserDisplay.be":
			action = new GetUserDisplayAction();
			break;
		case "/updateUserDisplay.be":
			action = new UpdateUserDisplayAction();
			break;
		case "/updateUserForID.be":
			action = new UpdateUserForIDAction();
			break;
		case "/updateUserListDisplay.be":
			action = new UpdateUserListDisplayAction();
			break;
		case "/deleteUserForID.be":
			action = new DeleteUserForIDAction();
			break;
			
//			관리자 기능 
		case "/updateAdminDisplay.be":
			action = new UpdateAdminDisplayAction();
			break;
		case "/updateAdminForID.be":
			action = new UpdateAdminForIDAction();
			break;
		case "/deleteAdminForID.be":
			action = new DeleteAdminForIDAction();
			break;
			
			
		default:
			action = new DefaultAction();
			break;
		}
		
		try {
			forward = action.execute(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request, response);	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request, response);
	}
}
