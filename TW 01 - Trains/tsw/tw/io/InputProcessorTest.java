package tw.io;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class InputProcessorTest {
	
	@Test
	public void testInvalidInput() {
		String input = null;
		
		assertFalse( InputProcessor.isInputValid(input) );
	}
	
	@Test
	public void testBasicInputValid() {
		String input = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
		
		Assert.assertTrue( InputProcessor.isInputValid(input));
	}
	
	@Test
	public void testBasicInputInValidNoSpaces() {
		String input = "AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7";
		
		Assert.assertFalse( InputProcessor.isInputValid(input));
	}
	
	@Test
	public void testBasicInputInValidNoCommas() {
		String input = "AB5 BC4 CD8 DC8 DE6 AD5 CE2 EB3 AE7";
		
		Assert.assertFalse( InputProcessor.isInputValid(input));
	}
	
	@Test
	public void testBasicInputInValidNoSpacesNoCommas() {
		String input = "AB5BC4CD8DC8DE6AD5CE2EB3AE7";
		
		Assert.assertFalse( InputProcessor.isInputValid(input));
	}
	
	@Test
	public void testBasicInputInValidNoDistances() {
		String input = "AB, BC, CD, DC, DE, AD, CE, EB, AE";
		
		Assert.assertFalse( InputProcessor.isInputValid(input));
	}
	
	@Test
	public void testBasicInputInValidNoBinaryPaths() {
		String input = "A5, B4, C8, D8, D6, A5, C2, E3, A7";
		
		Assert.assertFalse( InputProcessor.isInputValid(input));
	}
	
}
