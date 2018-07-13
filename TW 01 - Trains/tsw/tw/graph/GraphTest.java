package tw.graph;

import static org.junit.Assert.*;

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
		
		assertNotNull(			this.aGraph );
		assertNotNull(			this.aGraph.getVertex("A") );
		assertNotNull(			this.aGraph.getVertex("A").getVertices() );
		assertEquals(	1,		this.aGraph.getVertex("A").getVertices().size() );
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B") );
		assertEquals(	"B",	this.aGraph.getVertex("A").getVertex("B").getName() );
		assertEquals(	5,		this.aGraph.getVertex("A").getDistanceNextVertex() );
	}
	
	@Test
	public void createTwoVertices() {
		String input = "AB5, BC4";
		this.aGraph.insertVertices(input);
		
		assertNotNull(			this.aGraph );
		assertNotNull(			this.aGraph.getVertex("A") );
		assertNotNull(			this.aGraph.getVertex("A").getVertices() );
		assertEquals(	1,		this.aGraph.getVertex("A").getVertices().size() );
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B") );
		assertEquals(	"B",	this.aGraph.getVertex("A").getVertex("B").getName() );
		assertEquals(	5,		this.aGraph.getVertex("A").getDistanceNextVertex() );
		
		assertNotNull(			this.aGraph );
		assertNotNull(			this.aGraph.getVertex("B") );
		assertNotNull(			this.aGraph.getVertex("B").getVertices() );
		assertEquals(	1,		this.aGraph.getVertex("A").getVertices().size() );
		assertNotNull(			this.aGraph.getVertex("B").getVertex("C") );
		assertEquals(	"C",	this.aGraph.getVertex("B").getVertex("C").getName() );
		assertEquals(	4,		this.aGraph.getVertex("B").getDistanceNextVertex() );
	}
	
	@Test
	public void testContinuousPathBetweenThreeVertices() {
		String input = "AB5, BC4";
		this.aGraph.insertVertices(input);
		
		assertNotNull(			this.aGraph );
		assertNotNull(			this.aGraph.getVertex("A") );
		assertEquals(	"A",	this.aGraph.getVertex("A").getName() );
		
		// Vertex B
		assertNotNull(			this.aGraph.getVertex("A").getVertices() );
		assertEquals(	1,		this.aGraph.getVertex("A").getVertices().size() );
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B") );
		assertEquals(	"B",	this.aGraph.getVertex("A").getVertex("B").getName() );
		
		// Vertex C
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B").getVertices() );
		assertEquals(	1,		this.aGraph.getVertex("A").getVertex("B").getVertices().size() );
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B").getVertex("C") );
		assertEquals(	"C",	this.aGraph.getVertex("A").getVertex("B").getVertex("C").getName() );
	}
	
	@Test
	public void testContinuousPathBetweenFourVertices() {
		String input = "AB5, BC4, CD8";
		this.aGraph.insertVertices(input);
		
		assertNotNull(			this.aGraph );
		assertNotNull(			this.aGraph.getVertex("A") );
		assertEquals(	"A",	this.aGraph.getVertex("A").getName() );
		
		// Vertex B
		assertNotNull(			this.aGraph.getVertex("A").getVertices() );
		assertEquals(	1,		this.aGraph.getVertex("A").getVertices().size() );
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B") );
		assertEquals(	"B",	this.aGraph.getVertex("A").getVertex("B").getName() );
		
		// Vertex C
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B").getVertices() );
		assertEquals(	1,		this.aGraph.getVertex("A").getVertex("B").getVertices().size() );
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B").getVertex("C") );
		assertEquals(	"C",	this.aGraph.getVertex("A").getVertex("B").getVertex("C").getName() );
		
		// Vertex D
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertices() );
		assertEquals(	1,		this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertices().size() );
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertex("D") );
		assertEquals(	"D",	this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertex("D").getName() );
	}
	
	@Test
	public void testContinuousPathBetweenFiveVertices() {
		String input = "AB5, BC4, CD8, DE6";
		this.aGraph.insertVertices(input);
		
		assertNotNull( this.aGraph );
		assertNotNull( this.aGraph.getVertex("A") );
		
		// Vertex B
		assertNotNull(			this.aGraph.getVertex("A").getVertices() );
		assertEquals(	1,		this.aGraph.getVertex("A").getVertices().size() );
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B") );
		
		// Vertex C
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B").getVertices() );
		assertEquals(	1,		this.aGraph.getVertex("A").getVertex("B").getVertices().size() );
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B").getVertex("C") );
		
		// Vertex D
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertices() );
		assertEquals(	1,		this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertices().size() );
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertex("D") );
		
		// Vertex E
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertex("D").getVertices() );
		assertEquals(	1,		this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertex("D").getVertices().size() );
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertex("D").getVertex("E") );
	}
	
	@Test
	public void testContinuousPathBetweenFourVerticesWithLoop() {
		String input = "AB5, BC4, CD8, DC8";
		this.aGraph.insertVertices(input);
		
		assertNotNull( this.aGraph );
		assertNotNull( this.aGraph.getVertex("A") );
		
		// Vertex B
		assertNotNull(			this.aGraph.getVertex("A").getVertices() );
		assertEquals(	1,		this.aGraph.getVertex("A").getVertices().size() );
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B") );
		
		// Vertex C
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B").getVertices() );
		assertEquals(	1,		this.aGraph.getVertex("A").getVertex("B").getVertices().size() );
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B").getVertex("C").getName() );
		
		// Vertex D
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertices() );
		assertEquals(	1,		this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertices().size() );
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertex("D") );
		
		/* Edge between D and C Vertices
		 *														B				C				D				C
		 */
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertex("D").getVertices() );
		assertEquals(	1,		this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertex("D").getVertices().size() );
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertex("D").getVertex("C") );
	}
	
	@Test
	public void testContinuousPathBetweenFiveVerticesWithLoopAndTwoEdgesFromSingleVertex() {
		String input = "AB5, BC4, CD8, DC8, DE6";
		this.aGraph.insertVertices(input);
		
		assertNotNull( this.aGraph );
		assertNotNull( this.aGraph.getVertex("A") );
		
		// Vertex B
		assertNotNull(			this.aGraph.getVertex("A").getVertices() );
		assertEquals(	1,		this.aGraph.getVertex("A").getVertices().size() );
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B") );
		
		// Vertex C
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B").getVertices() );
		assertEquals(	1,		this.aGraph.getVertex("A").getVertex("B").getVertices().size() );
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B").getVertex("C") );
		
		// Vertex D
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertices() );
		assertEquals(	1,		this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertices().size() );
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertex("D") );
		
		/* Edge between D and E Vertices
		 *														B				C				D				C
		 */
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertex("D").getVertices() );
		assertEquals(	2,		this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertex("D").getVertices().size() );
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertex("D").getVertex("C") );
		
		Vertex cFromAandB			= this.aGraph.getVertex("A").getVertex("B").getVertex("C");
		Vertex cFromAandBandCandD	= this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertex("D").getVertex("C");
		assertEquals(	cFromAandB,		cFromAandBandCandD	);
		assertSame(		cFromAandB,		cFromAandBandCandD	);
		
		assertNotNull(			this.aGraph.getVertex("A").getVertex("B").getVertex("C").getVertex("D").getVertex("E") );
	}
	
	// String input = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
	
}