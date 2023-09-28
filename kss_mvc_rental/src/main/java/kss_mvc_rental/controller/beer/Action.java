package kss_mvc_rental.controller.beer;

import javax.servlet.http.*;

public interface Action {
	public ActionForward execute(HttpServletRequest request,
								 HttpServletResponse response) throws Exception;
}
