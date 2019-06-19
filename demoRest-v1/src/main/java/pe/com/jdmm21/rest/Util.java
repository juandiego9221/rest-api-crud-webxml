package pe.com.jdmm21.rest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
	
	public static String readInputStream(InputStream stream) {
		return new BufferedReader(new InputStreamReader(stream)).lines().collect(Collectors.joining("\n"));
	}
	
	public static List<String> splitString (String cadena) {
		return Arrays.stream(cadena.split("/")).filter(e->!e.isEmpty()).collect(Collectors.toList());
	}
	

}
