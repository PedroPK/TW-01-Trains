package tw.regexp;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import tw.regexp.RegExpProcessor;

@FixMethodOrder(MethodSorters.JVM)
public class RegExpProcessorTest {
	
	@Test
	public void testInvalidNullInput() {
		String input = null;
		
		assertFalse( RegExpProcessor.isPathValid(input) );
	}
	
	@Test
	public void testInvalidEmptyInput() {
		String input = "";
		
		assertFalse( RegExpProcessor.isPathValid(input) );
	}
	
	@Test
	public void testMinimalInputValid() {
		String input = "AB5";
		
		assertTrue( RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testGetFirstVertex() {
		String input = "AB5";
		
		String response = RegExpProcessor.getFirstVertex(input);
		
		String expected = "A";
		assertEquals( expected, response );
	}
	
	@Test
	public void testGetSecondVertex() {
		String input = "AB5";
		
		String response = RegExpProcessor.getSecondVertex(input);
		
		String expected = "B";
		assertEquals( expected, response );
	}
	
	@Test
	public void testGetDistanceVertex() {
		String input = "AB5";
		
		int response = RegExpProcessor.getDistance(input);
		
		int expected = 5;
		assertEquals( expected, response );
	}
	
	@Test
	public void testSinglePathValid() {
		String input = "AB5";
		
		assertTrue( RegExpProcessor.isSinglePathValid(input));
	}
	
	@Test
	public void testSinglePathInvalidWithComma() {
		String input = "AB5,";
		
		assertFalse( RegExpProcessor.isSinglePathValid(input));
	}
	
	@Test
	public void testSinglePathInvalidWithCommaSpace() {
		String input = "AB5, ";
		
		assertFalse( RegExpProcessor.isSinglePathValid(input));
	}
	
	@Test
	public void testSinglePathInvalidWithTwoPaths() {
		String input = "AB5, BC4";
		
		assertFalse( RegExpProcessor.isSinglePathValid(input));
	}
	
	@Test
	public void testMinimalInputInvalidWithComma() {
		String input = "AB5,";
		
		assertFalse(RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testMinimalInputInvalidWithCommaAndSpace() {
		String input = "AB5, ";
		
		assertFalse(RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testDualInputValid() {
		String input = "AB5, BC4";
		
		assertTrue( RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testDualInputInvalidNoDistance() {
		String input = "AB5, BC";
		
		assertFalse( RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testDualInputInvalidNoDistanceNoDestination() {
		String input = "AB5, B";
		
		assertFalse( RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testDualInputInvalidNoDestination() {
		String input = "AB5, B1";
		
		assertFalse( RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testDualInputInvalidNoOriginNoDestination() {
		String input = "AB5, 1";
		
		assertFalse( RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testTripleInputValid() {
		String input = "AB5, BC4, CD8";
		
		assertTrue( RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testQuadripleInputValid() {
		String input = "AB5, BC4, CD8, DC8";
		
		assertTrue( RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testBasicInputValid() {
		String input = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
		
		assertTrue( RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testBasicInputInValidNoSpaces() {
		String input = "AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7";
		
		assertFalse( RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testBasicInputInValidNoCommas() {
		String input = "AB5 BC4 CD8 DC8 DE6 AD5 CE2 EB3 AE7";
		
		assertFalse( RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testBasicInputInValidNoSpacesNoCommas() {
		String input = "AB5BC4CD8DC8DE6AD5CE2EB3AE7";
		
		assertFalse( RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testBasicInputInValidNoDistances() {
		String input = "AB, BC, CD, DC, DE, AD, CE, EB, AE";
		
		assertFalse( RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testBasicInputInValidNoBinaryPaths() {
		String input = "A5, B4, C8, D8, D6, A5, C2, E3, A7";
		
		assertFalse( RegExpProcessor.isPathValid(input));
	}
	
}
