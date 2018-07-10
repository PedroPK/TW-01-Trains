package tw.graph;

import java.util.HashMap;
import java.util.Map;

public class Graph {
	
	private Map<String, Vertex>		aVertices;
	
	public Graph() {
		this.aVertices = new HashMap<String, Vertex>();
	}
	
	public void addVertex(String pNameVertex, Vertex pVertex) {
		if ( !this.aVertices.containsKey(pNameVertex) ) {
			this.aVertices.put(pNameVertex, pVertex);
		} else {
			this.aVertices.get(pNameVertex).setNextVertex(pVertex);
		}
	}
	public void addVertex(Vertex pVertex) {
		if ( !this.aVertices.containsKey(pVertex.getName()) ) {
			this.aVertices.put(pVertex.getName(), pVertex);
		} else {
			this.aVertices.get(pVertex.getName()).setNextVertex(pVertex);
		}
		
		
	}
	
	public Vertex getVertex( String pName ) {
		Vertex response = null;
		
		for ( String vertexName:  this.aVertices.keySet() ) {
			response = this.aVertices.get(vertexName).getVertex(pName);
			
			if ( response != null ) {
				break;
			}
		}
		
		return response;
	}
	
	public boolean containsVertex( String pName ) {
		boolean response = false;
		
		if (	this.aVertices != null && !this.aVertices.isEmpty() ) {
			if ( this.aVertices.containsKey(pName) ) {
				response = true;
			} else {
				for ( String vertexName: this.aVertices.keySet() ) {
					response = this.aVertices.get(vertexName).containsVertex(pName);
					
					if ( response ) {
						break;
					}
				}
			}
			
		}
		
		return response;
	}
	
}