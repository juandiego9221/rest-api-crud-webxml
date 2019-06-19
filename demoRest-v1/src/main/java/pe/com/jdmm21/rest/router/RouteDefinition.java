package pe.com.jdmm21.rest.router;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import pe.com.jdmm21.rest.Util;

public class RouteDefinition {
	
	private String verb;
	private List<String> pathBits;
	String rest ;
	public RouteDefinition(String route) {
		String [] parts = route.split(" ");
		verb = parts[0];
		
		rest = Arrays.stream(parts).skip(1L).collect(Collectors.joining(" "));
		pathBits= Util.splitString(rest);
		
		
	}
	
	public boolean matches(HttpServletRequest req) {
		return matches(req.getMethod(), req.getRequestURI());
		
	}
	
	public boolean matches(String method,String uri) {

		if(!verb.equals(method)) {
			return false;
		}
		
		List<String> providedUri =   Util.splitString(uri);
		
		if(providedUri.size()!=pathBits.size()) {
			return false;
		}
		
		for(int i = 0; i<providedUri.size();i++) {
			String provideBit = providedUri.get(i);
			String patternBit = pathBits.get(i);
			
			System.out.println("xx1: " + provideBit);
			System.out.println("xx2: " + patternBit);
			
			if(patternBit.startsWith(":")) {
				continue;
			}

			if(!patternBit.equalsIgnoreCase(provideBit)) {
				return false;
			}
		}
		
		return true;
	}

}
