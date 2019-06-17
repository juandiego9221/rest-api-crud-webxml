package pe.com.jdmm21.rest.router;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.com.jdmm21.rest.todo.TodoServlet;
import pe.com.jdmm21.rest.todo.TodosServlet;

public class RouterServlet extends HttpServlet{
	
	private static final TodosServlet TODOS_SERVLET = new TodosServlet();
	private  static final TodoServlet TODO_SERVLET = new TodoServlet();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		
		if(uri.startsWith("/demoRest-v1/todos/")) {
			TODO_SERVLET.doGet(req, resp);
		}else if(uri.startsWith("/demoRest-v1/todos")){
			TODOS_SERVLET.doGet(req, resp);
		}else {
			resp.setStatus(404);
			resp.getWriter().println("NO SE ENCONTRO URI");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		
		if(uri.startsWith("/demoRest-v1/todos/")) {
			TODO_SERVLET.doPost(req, resp);
		}else if(uri.startsWith("/demoRest-v1/todos")){
			TODOS_SERVLET.doPost(req, resp);
		}else {
			resp.setStatus(404);
			resp.getWriter().println("NO SE ENCONTRO URI");
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		
		if(uri.startsWith("/demoRest-v1/todos/")) {
			TODO_SERVLET.doPut(req, resp);
		}else if(uri.startsWith("/demoRest-v1/todos")){
			resp.setStatus(404);
			resp.getWriter().println("ERROR");
		}else {
			resp.setStatus(404);
			resp.getWriter().println("NO SE ENCONTRO URI");
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		
		if(uri.startsWith("/demoRest-v1/todos/")) {
			TODO_SERVLET.doDelete(req, resp);
		}else if(uri.startsWith("/demoRest-v1/todos")){
			resp.setStatus(404);
			resp.getWriter().println("ERROR");
		}else {
			resp.setStatus(404);
			resp.getWriter().println("NO SE ENCONTRO URI");
		}
	}

}
