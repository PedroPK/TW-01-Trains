package tw.graph;

import java.util.Map;
import java.util.TreeMap;

import tw.regexp.RegExpProcessor;

public class Vertex {
	
	/**
	 * Attributes
	 */
	private String					aName;
	private Map<String, Vertex>		aVertices;
	private int						aDistanceNextVertex;
	
	/**
	 * Constructor
	 * 
	 * @param pName
	 * @param pNextVertex
	 * @param pDistanceNexVertex
	 */
	public Vertex() {}
	public Vertex(String pPath) {
		if ( RegExpProcessor.isSinglePathValid(pPath) ) {
			String fistVertexName = RegExpProcessor.getFirstVertex(pPath);
			String secondVertexName = RegExpProcessor.getSecondVertex(pPath);
			int distanceName = RegExpProcessor.getDistance(pPath);
			
			this.aName = fistVertexName;
			
			Vertex nextVertex = new Vertex();
			nextVertex.setName(secondVertexName);
			
			addVertex(nextVertex);
			
			this.aDistanceNextVertex = distanceName;
		}
	}
	
	public void addVertex(Vertex pVertex) {
		if ( this.aVertices == null && pVertex != null) {
			this.aVertices = new TreeMap<String, Vertex>();
		}
		this.aVertices.put(pVertex.getName(), pVertex);
	}
	
	public Vertex(
		String	pName,
		Vertex	pNextVertex,
		int		pDistanceNexVertex
	) {
		this.aName					= pName;
		this.aDistanceNextVertex	= pDistanceNexVertex;
		addVertex(pNextVertex);
	}
	
	/**
	 * Getters
	 * 
	 * @return
	 */
	public String getName() {
		return this.aName;
	}
	
	public Map<String, Vertex> getVertices() {
		return this.aVertices;
	}
	
	public int getDistanceNextVertex() {
		return this.aDistanceNextVertex;
	}
	
	/**
	 * Setters
	 * 
	 * @param pName
	 * @param pNextVertex
	 * @param pDistanceNextVertex
	 */
	public void setName(String pName) {
		this.aName = pName;
	}
	public void setVertices(Map<String, Vertex> pVertices) {
		this.aVertices = pVertices;
	}
	public void setDistanceNextVertex(int pDistanceNextVertex) {
		this.aDistanceNextVertex = pDistanceNextVertex;
	}
	
	public boolean containsVertex( String pName ) {
		boolean response = false;
		
		if ( this.aName != null && this.aName.length() > 0 ) {
			if ( this.aName.equals(pName) ) {
				response = true;
			} else {
				if ( this.aVertices != null ) {
					for ( String vertexName: this.aVertices.keySet() ) {
						response = this.aVertices.get(vertexName).containsVertex(pName);
						
						// If the Vertex was found
						if ( response ) {
							break;
						}
					}
				}
			}
		}
		
		return response;
	}
	
	public Vertex getVertex( String pName) {
		Vertex response = getVertex( pName, 10);
		
		return response;
	}
	
	public Vertex getVertex( String pName, int pHops ) {
		Vertex response = null;
		
		if ( this.aName != null && this.aName.length() > 0 ) {
			if ( this.aName.equals(pName) ) {
				response = this;
			} else {
				if (
						this.aVertices != null		&&
						pHops > 0
				) {
					//response = this.aVertices.getVertex(pName);
					
					for ( String vertexName: this.aVertices.keySet() ) {
						response = this.aVertices.get(vertexName).getVertex(pName, pHops - 1);
						
						// If the Vertex was found
						if ( response != null ) {
							break;
						}
					}
				}
			}
		}
		
		return response;
	}
	
}