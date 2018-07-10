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
	 * @param aName
	 * @param aNextVertex
	 * @param aDistanceNextVertex
	 */
	public void setName(String aName) {
		this.aName = aName;
	}
	public void setNextVertex(Vertex aNextVertex) {
		this.aNextVertex = aNextVertex;
	}
	public void setDistanceNextVertex(int aDistanceNextVertex) {
		this.aDistanceNextVertex = aDistanceNextVertex;
	}
	
}