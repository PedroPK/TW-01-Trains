package tw.graph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import tw.io.InputProcessor;

public class GraphTest {
	
	private Graph	aGraph;
	
	@Before
	public void before() {
		this.aGraph = new Graph();
	}
	
	@Test
	public void createBasicVertex() {
		String input = "AB5";
		Set<String> paths = InputProcessor.getPaths(input);
		
		for ( String path: paths ) {
			Vertex vertex = new Vertex(path);
			this.aGraph.addVertex(vertex.getName(), vertex);
		}
		
		assertNotNull(	this.aGraph );
		assertNotNull(	this.aGraph.getVertex("A") );
		assertNotNull(	this.aGraph.getVertex("A").getVertices() );
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B") );
		assertEquals(	5,		this.aGraph.getVertex("A").getDistanceNextVertex() );
	}
	
	@Test
	public void createTwoVertices() {
		String input = "AB5, BC4";
		this.aGraph.insertVertices(input);
		
		assertNotNull(	this.aGraph );
		assertNotNull(	this.aGraph.getVertex("A") );
		assertNotNull(	this.aGraph.getVertex("A").getVertices() );
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B") );
		assertEquals(	5,		this.aGraph.getVertex("A").getDistanceNextVertex() );
		
		assertNotNull(	this.aGraph );
		assertNotNull(	this.aGraph.getVertex("B") );
		assertNotNull(	this.aGraph.getVertex("B").getVertices() );
		assertNotNull(	this.aGraph.getVertex("B").getVertex("C") );
		assertEquals(	4,		this.aGraph.getVertex("B").getDistanceNextVertex() );
	}
	
	@Test
	public void testContinuousPathBetweenThreeVertices() {
		String input = "AB5, BC4";
		this.aGraph.insertVertices(input);
		
		assertNotNull( this.aGraph );
		assertNotNull( this.aGraph.getVertex("A") );
		
		// Vertex B
		assertNotNull(	this.aGraph.getVertex("A").getVertices() );
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B") );
		
		// Vertex C
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B").getVertices() );
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B").getVertex("C") );
	}
	
	@Test
	public void testContinuousPathBetweenFourVertices() {
		String input = "AB5, BC4, CD8";
		this.aGraph.insertVertices(input);
		
		assertNotNull(	this.aGraph );
		assertNotNull(	this.aGraph.getVertex("A") );
		
		// Vertex B
		assertNotNull(	this.aGraph.getVertex("A").getVertices() );
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B") );
		
		// Vertex C
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B").getVertices() );
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B").getVertex("C") );
		
		// Vertex D
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertices() );
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertex("D") );
	}
	
	@Test
	public void testContinuousPathBetweenFiveVertices() {
		String input = "AB5, BC4, CD8, DE6";
		this.aGraph.insertVertices(input);
		
		assertNotNull( this.aGraph );
		assertNotNull( this.aGraph.getVertex("A") );
		
		// Vertex B
		assertNotNull(	this.aGraph.getVertex("A").getVertices() );
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B") );
		
		// Vertex C
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B").getVertices() );
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B").getVertex("C") );
		
		// Vertex D
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertices() );
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertex("D") );
		
		// Vertex E
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertex("D").getVertices() );
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertex("D").getVertex("E") );
	}
	
	@Test
	public void testContinuousPathBetweenFourVerticesWithLoop() {
		String input = "AB5, BC4, CD8, DC8";
		this.aGraph.insertVertices(input);
		
		assertNotNull( this.aGraph );
		assertNotNull( this.aGraph.getVertex("A") );
		
		// Vertex B
		assertNotNull(	this.aGraph.getVertex("A").getVertices() );
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B") );
		
		// Vertex C
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B").getVertices() );
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B").getVertex("C").getName() );
		
		// Vertex D
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertices() );
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertex("D") );
		
		/* Edge between D and C Vertices
		 *														B				C				D				C
		 */
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertex("D").getVertices() );
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertex("D").getVertex("C") );
	}
	
	@Test
	public void testContinuousPathBetweenFiveVerticesWithLoopAndTwoEdgesFromSingleVertex() {
		String input = "AB5, BC4, CD8, DC8, DE6";
		this.aGraph.insertVertices(input);
		
		assertNotNull( this.aGraph );
		assertNotNull( this.aGraph.getVertex("A") );
		
		// Vertex B
		assertNotNull(	this.aGraph.getVertex("A").getVertices() );
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B") );
		
		// Vertex C
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B").getVertices() );
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B").getVertex("C") );
		
		// Vertex D
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertices() );
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertex("D") );
		
		/* Edge between D and E Vertices
		 *														B				C				D				C
		 */
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertex("D").getVertices() );
		assertNotNull(	this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertex("D").getVertex("E") );
	}
	
	// String input = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
	
}