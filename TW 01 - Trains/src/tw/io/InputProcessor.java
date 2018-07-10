package tw.io;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import tw.regexp.RegExpProcessor;

public class InputProcessor {
	
	public static Set<String> getPaths(String pInput) {
		Set<String> response = null;
		
		if ( RegExpProcessor.isPathValid(pInput) ) {
			response = new TreeSet<String>(		Arrays.asList( pInput.split(", ") )		);
		}
		
		return response;
	}
	
}