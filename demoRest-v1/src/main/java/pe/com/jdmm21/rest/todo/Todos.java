package pe.com.jdmm21.rest.todo;

import java.util.HashMap;
import java.util.Map;

public class Todos {
	
	public static Map<Long, Todo> todos = new HashMap<>();
	
	static {
		todos.put((long)1, new Todo("hola1", (long)1));
		todos.put((long)2, new Todo("hola2", (long)2));	
		todos.put((long)3, new Todo("hola3", (long)3));	
	}
	
	public static Long nextId() {
		return todos.keySet().stream().reduce(Math::max).orElse((long) 0)+(long)1;
	}

}
