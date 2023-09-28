package kss_mvc_rental.controller.order.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import java.util.Enumeration;



import java.util.*;
import kss_mvc_rental.controller.beer.Action;
import kss_mvc_rental.controller.beer.ActionForward;
import kss_mvc_rental.model.order.*;
import kss_mvc_rental.model.order.OrderDAO;
import kss_mvc_rental.model.order.OrderDTO;


public class InsertOrderAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		

		request.setCharacterEncoding("utf-8");
		
		OrderDAO orderDAO = new OrderDAO();
		OrderDTO order = new OrderDTO();
		
		order.setO_name(request.getParameter("o_name"));
		order.setO_phone(request.getParameter("o_phone"));
		order.setO_address(request.getParameter("o_address"));
		order.setO_memo(request.getParameter("o_memo"));
		order.setO_payment(request.getParameter("o_payment"));
		
		boolean result = orderDAO.insertOrder(order);
		
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

