package pe.com.jdmm21.rest.todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import pe.com.jdmm21.rest.Util;

public class TodoServlet extends HttpServlet{
	
	private static final Gson GSON = new GsonBuilder().create();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		Long id = Long.parseLong(uri.substring("/demoRest-v1/todos/".length()));
		String json = GSON.toJson(Todos.todos.get(id));
		resp.setStatus(200);
		resp.setHeader("Content-Type", "application/json");
		resp.getOutputStream().println(json);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		Long id = Long.parseLong(uri.substring("/demoRest-v1/todos/".length()));
		
		Todo todo = Todos.todos.remove(id);
		String json =GSON.toJson(todo);
		
		resp.setStatus(200);
		resp.setHeader("Content-Type", "application/json");
		resp.getOutputStream().println(json);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		Long id = Long.parseLong(uri.substring("/demoRest-v1/todos/".length()));
		
		if(Todos.todos.containsKey(id)) {
			resp.setStatus(422);
			resp.getOutputStream().println("IT REPEATS: " + id);
		}
		
		String json =  Util.readInputStream(req.getInputStream());
		Todo todo =GSON.fromJson(json, Todo.class);
		todo.setId(id);

		Todos.todos.put(todo.getId(), todo);
		
		resp.setStatus(201);
		resp.setHeader("Content-Type", "application/json");
		resp.getOutputStream().println(GSON.toJson(todo));
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		Long id = Long.parseLong(uri.substring("/demoRest-v1/todos/".length()));
		
		if(!Todos.todos.containsKey(id)) {
			resp.setStatus(422);
			resp.getOutputStream().println("IT DOESNT EXIST: " + id);
		}
		
		String json =  Util.readInputStream(req.getInputStream());
		Todo todo =GSON.fromJson(json, Todo.class);
		todo.setId(id);

		Todos.todos.put(todo.getId(), todo);
		
		resp.setStatus(201);
		resp.setHeader("Content-Type", "application/json");
		resp.getOutputStream().println(GSON.toJson(todo));
	}
	
}
