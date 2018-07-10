package tw.graph;

import java.util.HashMap;
import java.util.Map;

public class Graph {
	
	private Map<String, Vertex>		aVertices;
	
	public Graph() {
		this.aVertices = new HashMap<String, Vertex>();
	}
	
	public void addVertex(String pNameVertex, Vertex pVertex) {
		this.aVertices.put(pNameVertex, pVertex);
	}
	public void addVertex(Vertex pVertex) {
		this.aVertices.put(pVertex.getName(), pVertex);
	}
	
	public Vertex getVertex( String pName ) {
		Vertex response = null;
		
		if ( this.aVertices.containsKey(pName) ) {
			response = this.aVertices.get(pName);
		}
		
		return response;
	}
	
}