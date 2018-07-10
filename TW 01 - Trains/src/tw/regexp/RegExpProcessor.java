package tw.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpProcessor {
	
	public static boolean isPathValid(String pInput) {
		boolean response = false;
		
		if ( pInput != null && pInput.length() > 0 ) {
			String firstVertex = "[a-zA-Z]";
			String secondVertex = firstVertex;
			String distance = "[1-9]";
			String separator = "(, )";
			
			//					[a-zA-Z]		[a-zA-Z]		[0-9]
			String minimalPath = firstVertex + secondVertex + distance;
			
			//		(([a-zA-Z][a-zA-Z][0-9])((, )[a-zA-Z][a-zA-Z][0-9])*)
			String pattern = 
				"(" +
					"(" +
						minimalPath +
					")" +
					"(" + 
						separator +
						minimalPath +
					")*" +
				")"
			;
			
			Pattern regularExpression = Pattern.compile(pattern);
			Matcher matcher = regularExpression.matcher(pInput);
			response = matcher.matches();
		}
		
		return response;
	}
	
}