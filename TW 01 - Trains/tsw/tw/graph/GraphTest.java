package tw.graph;

import java.util.Set;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import tw.io.InputProcessor;
import tw.regexp.RegExpProcessor;

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
		
		assertNotNull( this.aGraph );
		assertNotNull( this.aGraph.getVertex("A") );
		assertNotNull( this.aGraph.getVertex("A").getNextVertex() );
		assertEquals(	"B",	this.aGraph.getVertex("A").getNextVertex().getName() );
		assertEquals(	5,		this.aGraph.getVertex("A").getDistanceNextVertex() );
	}
	
	@Test
	public void createTwoVertices() {
		String input = "AB5, BC4";
		Set<String> paths = InputProcessor.getPaths(input);
		
		for ( String path: paths ) {
			String	firstVertexName			= RegExpProcessor.getFirstVertex(path);
			String	secondVertexName		= RegExpProcessor.getSecondVertex(path);
			int		distanceVertexName		= RegExpProcessor.getDistance(path);
			
			if ( !this.aGraph.containsVertex(firstVertexName) ) {
				Vertex vertex = new Vertex(path);
				this.aGraph.addVertex(vertex.getName(), vertex);
			} else {
				this.aGraph.getVertex(firstVertexName).setDistanceNextVertex(distanceVertexName);
				
				Vertex vertex = new Vertex();
				vertex.setName(secondVertexName);
				this.aGraph.getVertex(firstVertexName).setNextVertex(vertex);
			}
			
		}
		
		assertNotNull( this.aGraph );
		assertNotNull( this.aGraph.getVertex("A") );
		assertNotNull( this.aGraph.getVertex("A").getNextVertex() );
		assertEquals(	"B",	this.aGraph.getVertex("A").getNextVertex().getName() );
		assertEquals(	5,		this.aGraph.getVertex("A").getDistanceNextVertex() );
		
		assertNotNull( this.aGraph );
		assertNotNull( this.aGraph.getVertex("B") );
		assertNotNull( this.aGraph.getVertex("B").getNextVertex() );
		assertEquals(	"C",	this.aGraph.getVertex("B").getNextVertex().getName() );
		assertEquals(	4,		this.aGraph.getVertex("B").getDistanceNextVertex() );
	}
	
	@Test
	public void testContinuousPathBetweenThreeVertices() {
		String input = "AB5, BC4";
		Set<String> paths = InputProcessor.getPaths(input);
		
		for ( String path: paths ) {
			String	firstVertexName			= RegExpProcessor.getFirstVertex(path);
			String	secondVertexName		= RegExpProcessor.getSecondVertex(path);
			int		distanceVertexName		= RegExpProcessor.getDistance(path);
			
			if ( !this.aGraph.containsVertex(firstVertexName) ) {
				Vertex vertex = new Vertex(path);
				this.aGraph.addVertex(vertex.getName(), vertex);
			} else {
				this.aGraph.getVertex(firstVertexName).setDistanceNextVertex(distanceVertexName);
				this.aGraph.getVertex(firstVertexName).getVertex(secondVertexName);
			}
		}
		
		assertNotNull( this.aGraph );
		assertNotNull( this.aGraph.getVertex("A") );
		
		// Vertex B
		assertNotNull( this.aGraph.getVertex("A").getNextVertex() );
		assertEquals(	"B",	this.aGraph.getVertex("A").getNextVertex().getName() );
		
		// Vertex C
		assertNotNull(	this.aGraph.getVertex("A").getNextVertex().getNextVertex() );
		assertEquals(	"C",	this.aGraph.getVertex("A").getNextVertex().getNextVertex().getName() );
	}
	
}