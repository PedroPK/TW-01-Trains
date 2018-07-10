package tw.graph;

import tw.regexp.RegExpProcessor;

public class Vertex {
	
	/**
	 * Attributes
	 */
	private String	aName;
	private Vertex	aNextVertex;
	private int		aDistanceNextVertex;
	
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
			
			this.aNextVertex = nextVertex;
			
			this.aDistanceNextVertex = distanceName;
		}
	}
	public Vertex(
		String	pName,
		Vertex	pNextVertex,
		int		pDistanceNexVertex
	) {
		this.aName					= pName;
		this.aNextVertex			= pNextVertex;
		this.aDistanceNextVertex	= pDistanceNexVertex;
	}
	
	/**
	 * Getters
	 * 
	 * @return
	 */
	public String getName() {
		return aName;
	}
	public Vertex getNextVertex() {
		return aNextVertex;
	}
	public int getDistanceNextVertex() {
		return aDistanceNextVertex;
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
	public void setNextVertex(Vertex pNextVertex) {
		this.aNextVertex = pNextVertex;
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
				if ( this.aNextVertex != null ) {
					response = this.aNextVertex.containsVertex(pName);
				}
			}
		}
		
		return response;
	}
	
	public Vertex getVertex( String pName ) {
		Vertex response = null;
		
		if ( this.aName != null && this.aName.length() > 0 ) {
			if ( this.aName.equals(pName) ) {
				response = this;
			} else {
				if ( this.aNextVertex != null ) {
					response = this.aNextVertex.getVertex(pName);
				}
			}
		}
		
		return response;
	}
	
}