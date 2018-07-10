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
					getRegExpMinimalPath() +
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
	
	public static boolean isSinglePathValid(String pInput) {
		boolean response = false;
		
		if ( pInput != null && pInput.length() > 0 ) {
			String pattern = getRegExpMinimalPath();
			
			Pattern regularExpression = Pattern.compile(pattern);
			Matcher matcher = regularExpression.matcher(pInput);
			response = matcher.matches();
		}
		
		return response;
	}
	
	public static String getFirstVertex(String pInput) {
		String response = null;
		
		if ( isSinglePathValid(pInput) ) {
			response = pInput.substring(0, 1);
		}
		
		return response;
	}
	
	public static String getSecondVertex(String pInput) {
		String response = null;
		
		if ( isSinglePathValid(pInput) ) {
			response = pInput.substring(1, 2);
		}
		
		return response;
	}
	
	public static int getDistance(String pInput) {
		int response = 0;
		
		if ( isSinglePathValid(pInput) ) {
			response = Integer.parseInt(pInput.substring(2, 3));
		}
		
		return response;
	}
	
	private static String getRegExpMinimalPath() {
		String firstVertex = "[a-zA-Z]";
		String secondVertex = firstVertex;
		String distance = "[1-9]";
		
		//					[a-zA-Z]		[a-zA-Z]		[0-9]
		String minimalPath = firstVertex + secondVertex + distance;
		
		String pattern = 
			"(" +
				minimalPath +
			")"
		;
		return pattern;
	}
	
}