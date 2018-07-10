package tw.regexp;

import static org.junit.Assert.assertFalse;

import org.junit.Assert;
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
		
		Assert.assertTrue( RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testMinimalInputInvalidWithComma() {
		String input = "AB5,";
		
		Assert.assertFalse(RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testMinimalInputInvalidWithCommaAndSpace() {
		String input = "AB5, ";
		
		Assert.assertFalse(RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testDualInputValid() {
		String input = "AB5, BC4";
		
		Assert.assertTrue( RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testDualInputInvalidNoDistance() {
		String input = "AB5, BC";
		
		Assert.assertFalse( RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testDualInputInvalidNoDistanceNoDestination() {
		String input = "AB5, B";
		
		Assert.assertFalse( RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testDualInputInvalidNoDestination() {
		String input = "AB5, B1";
		
		Assert.assertFalse( RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testDualInputInvalidNoOriginNoDestination() {
		String input = "AB5, 1";
		
		Assert.assertFalse( RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testTripleInputValid() {
		String input = "AB5, BC4, CD8";
		
		Assert.assertTrue( RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testQuadripleInputValid() {
		String input = "AB5, BC4, CD8, DC8";
		
		Assert.assertTrue( RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testBasicInputValid() {
		String input = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
		
		Assert.assertTrue( RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testBasicInputInValidNoSpaces() {
		String input = "AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7";
		
		Assert.assertFalse( RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testBasicInputInValidNoCommas() {
		String input = "AB5 BC4 CD8 DC8 DE6 AD5 CE2 EB3 AE7";
		
		Assert.assertFalse( RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testBasicInputInValidNoSpacesNoCommas() {
		String input = "AB5BC4CD8DC8DE6AD5CE2EB3AE7";
		
		Assert.assertFalse( RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testBasicInputInValidNoDistances() {
		String input = "AB, BC, CD, DC, DE, AD, CE, EB, AE";
		
		Assert.assertFalse( RegExpProcessor.isPathValid(input));
	}
	
	@Test
	public void testBasicInputInValidNoBinaryPaths() {
		String input = "A5, B4, C8, D8, D6, A5, C2, E3, A7";
		
		Assert.assertFalse( RegExpProcessor.isPathValid(input));
	}
	
}
