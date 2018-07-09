package tw.io;

public class InputProcessor {
	
	public static boolean isInputValid(String pInput) {
		boolean response = false;
		
		if ( pInput != null && pInput.length() > 0 ) {
			response = true;
		}
		
		return response;
	}
	public void processInput(String pInput) {
		
	}
	
}