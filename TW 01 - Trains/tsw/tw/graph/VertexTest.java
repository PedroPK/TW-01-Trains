package tw.graph;

import static org.junit.Assert.*;
import org.junit.Test;

public class VertexTest {
	
	@Test
	public void testConstructorNullString() {
		String input = null;
		
		Vertex vertex = new Vertex(input);
		
		assertNotNull(			vertex);
		assertNull(				vertex.getName());
		assertNull(				vertex.getVertices());
		assertEquals(	0,		vertex.getDistanceNextVertex());
	}
	
	@Test
	public void testConstructorEmptyString() {
		String input = "";
		
		Vertex vertex = new Vertex(input);
		
		assertNotNull(			vertex);
		assertNull(				vertex.getName());
		assertNull(				vertex.getVertices());
		assertEquals(	0,		vertex.getDistanceNextVertex());
	}
	
	@Test
	public void testConstructorBasicPath() {
		String input = "AB5";
		
		Vertex vertex = new Vertex(input);
		
		assertNotNull(			vertex);
		assertNotNull(			vertex.getName());
		assertNotNull(			vertex.getVertices());
		assertEquals(	5,		vertex.getDistanceNextVertex());
		
		assertEquals(	"A",	vertex.getName());
		assertNotNull(			vertex.getVertex("B"));
		assertEquals(	"B",	vertex.getVertex("B").getName());
		assertNull(				vertex.getVertex("B").getVertices());
		assertEquals(	0,		vertex.getVertex("B").getDistanceNextVertex());
	}
	
}