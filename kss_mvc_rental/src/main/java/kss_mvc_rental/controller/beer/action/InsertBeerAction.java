package kss_mvc_rental.controller.beer.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import java.util.Enumeration;



import java.util.*;
import kss_mvc_rental.controller.beer.Action;
import kss_mvc_rental.controller.beer.ActionForward;
import kss_mvc_rental.model.beer.*;


public class InsertBeerAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		String imgDirPath = "C:\\Dev\\MyWorkspace\\kss_mvc_rental\\src\\main\\webapp\\com\\yju\\2wda\\team0\\image\\";

		int maxSize = 1024 * 1024 * 5;

		MultipartRequest multi = new MultipartRequest(request,
													  imgDirPath,
													  maxSize,
													  "utf-8",
													  new DefaultFileRenamePolicy());

//		String userName = multi.getParameter("userName");

		Enumeration<?> files = multi.getFileNames();

		String element = "";
		String filesystemName = "";
		String originalFileName = "";
		String contentType = "";
		long length = 0;

		if (files.hasMoreElements()) {
			
			element = (String)files.nextElement();
			
			filesystemName          = multi.getFilesystemName(element);
			originalFileName        = multi.getOriginalFileName(element);
			contentType          	= multi.getContentType(element);
			length          		= multi.getFile(element).length();
			
		}

		request.setCharacterEncoding("utf-8");
		BeerDAO beerDAO = new BeerDAO();
		BeerDTO beer = new BeerDTO();
		beer.setP_category(multi.getParameter("p_category"));
		beer.setP_store(multi.getParameter("p_store"));
		beer.setP_name(multi.getParameter("p_name"));
		beer.setP_price(Integer.parseInt(multi.getParameter("p_price")));
		beer.setP_state(multi.getParameter("p_state"));
		beer.setP_like(0);
		beer.setP_image(filesystemName);
		
		boolean result = beerDAO.insertBeer(beer);
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
