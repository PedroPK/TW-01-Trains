package tw.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;

public class InputProcessorTest {
	
	@Test
	public void testInvalidInput() {
		String input = null;
		
		Set<String> response = InputProcessor.getPaths(input);
		
		assertNull( response );
	}
	
	@Test
	public void testInvalidEmptyInput() {
		String input = "";
		
		Set<String> response = InputProcessor.getPaths(input);
		
		assertNull( response );
	}
	
	@Test
	public void testMinimalInputValid() {
		String input = "AB5";
		
		Set<String> response = InputProcessor.getPaths(input);
		
		Set<String> expected = new HashSet<String>();
		expected.add(input);
		
		assertNotNull( response );
		assertTrue( response.contains(input) );
	}
	
	@Test
	public void testDualInputValid() {
		String input = "AB5, BC4";
		
		Set<String> response = InputProcessor.getPaths(input);
		
		Set<String> expected = new HashSet<String>();
		String firstPath = "AB5";
		String secondPath = "BC4";
		expected.add(firstPath);
		expected.add(secondPath);
		
		assertNotNull( response );
		assertTrue( response.contains(firstPath) );
		assertTrue( response.contains(secondPath) );
		assertEquals(expected, response);
	}
	
	@Test
	public void testDualInputInvertedOrder() {
		String input = "AB5, BC4";
		
		Set<String> response = InputProcessor.getPaths(input);
		
		Set<String> expected = new HashSet<String>();
		String firstPath = "AB5";
		String secondPath = "BC4";
		expected.add(secondPath);
		expected.add(firstPath);
		
		assertNotNull( response );
		assertTrue( response.contains(firstPath) );
		assertTrue( response.contains(secondPath) );
		assertEquals(expected, response);
	}
	
	@Test
	public void testTripleInputValid() {
		String input = "AB5, BC4, CD8";
		
		Set<String> response = InputProcessor.getPaths(input);
		
		Set<String> expected = new HashSet<String>();
		String firstPath = "AB5";
		String secondPath = "BC4";
		String thrirdPath = "CD8";
		expected.add(firstPath);
		expected.add(secondPath);
		expected.add(thrirdPath);
		
		assertNotNull( response );
		assertTrue( response.contains(firstPath) );
		assertTrue( response.contains(secondPath) );
		assertTrue( response.contains(thrirdPath) );
		assertEquals(expected, response);
	}
	
	@Test
	public void testTripleInputInvertedOrder() {
		String input = "AB5, BC4, CD8";
		
		Set<String> response = InputProcessor.getPaths(input);
		
		Set<String> expected = new HashSet<String>();
		String firstPath = "AB5";
		String secondPath = "BC4";
		String thrirdPath = "CD8";
		expected.add(thrirdPath);
		expected.add(firstPath);
		expected.add(secondPath);
		
		assertNotNull( response );
		assertTrue( response.contains(firstPath) );
		assertTrue( response.contains(secondPath) );
		assertTrue( response.contains(thrirdPath) );
		assertEquals(expected, response);
	}
	
	@Test
	public void testQuadripleInputValid() {
		String input = "AB5, BC4, CD8, DC8";
		
		Set<String> response = InputProcessor.getPaths(input);
		
		Set<String> expected = new HashSet<String>();
		String firstPath = "AB5";
		String secondPath = "BC4";
		String thrirdPath = "CD8";
		String fourthPath = "DC8";
		expected.add(firstPath);
		expected.add(secondPath);
		expected.add(thrirdPath);
		expected.add(fourthPath);
		
		assertNotNull( response );
		assertTrue( response.contains(firstPath) );
		assertTrue( response.contains(secondPath) );
		assertTrue( response.contains(thrirdPath) );
		assertTrue( response.contains(fourthPath) );
		assertEquals(expected, response);
	}
	
	@Ignore
	@Test
	public void testBasicInputValid() {
		String input = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
		
		//Assert.assertTrue( InputProcessor.isInputValid(input));
	}
	
	@Ignore
	@Test
	public void testBasicInputInValidNoSpaces() {
		String input = "AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7";
		
		//Assert.assertFalse( InputProcessor.isInputValid(input));
	}
	
	@Ignore
	@Test
	public void testBasicInputInValidNoCommas() {
		String input = "AB5 BC4 CD8 DC8 DE6 AD5 CE2 EB3 AE7";
		
		//Assert.assertFalse( InputProcessor.isInputValid(input));
	}
	
	@Ignore
	@Test
	public void testBasicInputInValidNoSpacesNoCommas() {
		String input = "AB5BC4CD8DC8DE6AD5CE2EB3AE7";
		
		//Assert.assertFalse( InputProcessor.isInputValid(input));
	}
	
	@Ignore
	@Test
	public void testBasicInputInValidNoDistances() {
		String input = "AB, BC, CD, DC, DE, AD, CE, EB, AE";
		
		//Assert.assertFalse( InputProcessor.isInputValid(input));
	}
	
	@Ignore
	@Test
	public void testBasicInputInValidNoBinaryPaths() {
		String input = "A5, B4, C8, D8, D6, A5, C2, E3, A7";
		
		//Assert.assertFalse( InputProcessor.isInputValid(input));
	}
	
}
