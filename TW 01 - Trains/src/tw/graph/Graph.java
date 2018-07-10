package tw.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import tw.io.InputProcessor;
import tw.regexp.RegExpProcessor;

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
	
	public void insertVertices(String pInput) {
		Set<String> paths = InputProcessor.getPaths(pInput);
		
		for ( String path: paths ) {
			String	firstVertexName			= RegExpProcessor.getFirstVertex(path);
			String	secondVertexName		= RegExpProcessor.getSecondVertex(path);
			int		distanceVertexName		= RegExpProcessor.getDistance(path);
			
			if ( !this.containsVertex(firstVertexName) ) {
				Vertex vertex = new Vertex(path);
				this.addVertex(vertex.getName(), vertex);
			} else {
				this.getVertex(firstVertexName).setDistanceNextVertex(distanceVertexName);
				
				Vertex vertex = new Vertex();
				vertex.setName(secondVertexName);
				this.getVertex(firstVertexName).setNextVertex(vertex);
			}
		}
	}
	
}