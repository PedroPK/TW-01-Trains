package tw.io;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tw.regexp.RegExpProcessor;

public class InputProcessor {
	
	public static List<String> splitInput(String pInput) {
		List<String> response = null;
		
		if ( RegExpProcessor.isPathValid(pInput) ) {
			response = Arrays.asList( pInput.split(", ") );
		}
		
		return response;
	}
	
}