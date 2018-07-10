package tw.graph;

import java.util.Set;

import static org.junit.Assert.*;
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
		
		assertNotNull( this.aGraph );
		assertNotNull( this.aGraph.getVertex("A") );
		assertNotNull( this.aGraph.getVertex("A").getNextVertex() );
		assertEquals(	"B",	this.aGraph.getVertex("A").getNextVertex().getName() );
		assertEquals(	5,		this.aGraph.getVertex("A").getDistanceNextVertex() );
	}
	
}