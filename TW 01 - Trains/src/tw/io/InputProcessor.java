package tw.io;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import tw.regexp.RegExpProcessor;

public class InputProcessor {
	
	public static Set<String> getPaths(String pInput) {
		Set<String> response = null;
		
		if ( RegExpProcessor.isPathValid(pInput) ) {
			response = new HashSet<String>(		Arrays.asList( pInput.split(", ") )		);
		}
		
		return response;
	}
	
}