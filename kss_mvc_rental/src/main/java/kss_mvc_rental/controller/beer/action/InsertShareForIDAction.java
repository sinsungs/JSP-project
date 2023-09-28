package kss_mvc_rental.controller.beer.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import kss_mvc_rental.controller.beer.Action;
import kss_mvc_rental.controller.beer.ActionForward;
import kss_mvc_rental.model.beer.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class InsertShareForIDAction implements Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		Calendar cal = Calendar.getInstance();
//		Date nowTime = new Date();
		cal.setTime(new Date());
		SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss");
//		String time = sf.format(nowTime);
		String time = sf.format(cal.getTime());
		
		cal.add(Calendar.DATE, +1);
		String endtime = sf.format(cal.getTime());
		
		 int p_id = Integer.parseInt(request.getParameter("p_id"));
	
		 BeerDAO beerDAO = new BeerDAO();
		 BeerDTO beer = new BeerDTO();
	     beer = beerDAO.getBeer(p_id);
		 // p_id에 해당하는 객체를 얻음 
	     
	     request.setAttribute("beer", beer);
	     
	     HttpSession session = request.getSession();
		 String userID = (String) session.getAttribute("userid");
	     
		boolean result = beerDAO.insertShareForID(beer, userID, time, endtime);
		
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