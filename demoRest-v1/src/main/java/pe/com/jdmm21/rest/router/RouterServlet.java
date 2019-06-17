package pe.com.jdmm21.rest.router;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RouterServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		
		if(uri.startsWith("/demoRest-v1/hello")) {
			resp.getWriter().print("hello!");
		}else if(uri.startsWith("/demoRest-v1/goodbye")){
			resp.getWriter().println("byeee!");
		}else {
			resp.getWriter().println("xxxxxxxxx!");

		}
	}

}
