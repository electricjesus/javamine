public class Tile {
	private char type;		// M for mine, N for non-mine 
	private char status;	// U for unturned, R for revealed
	private Tile[] neighbors;
	private int numberOfMineNeighbors;
	private boolean isFlagged;	
	
	Tile(char type) {
		this.type = type;
		this.status = 'U'; // u for unturned.
		this.numberOfMineNeighbors = -1;
		this.isFlagged = false;
	}	
	
	// General setters
	public Tile setTileType( char _param ) 		{	this.type = _param; 	return this;	}
	public Tile setTileStatus( char _param ) 	{	this.status = _param; 	return this;	}
	public Tile setNeighbors(Tile[] _param) 	{	this.neighbors = _param;return this;	}
	public Tile setFlag( boolean _param ) 		{	this.isFlagged = _param;return this;	}
	
	// General logic
	public char getTileType() 	{	return this.type;	}
	public char getTileStatus() {	return this.status;	}
	
	// Some logic here..
	public Tile calculateNumOfMineNeighbors() {		
		this.numberOfMineNeighbors = 0;
		for(int i = 0; i < neighbors.length; i++ )
			if(neighbors[i].getTileType() == 'M') this.numberOfMineNeighbors++;			
		return this;	
	}
	public Tile[] getNeighbors() {
		return neighbors;
	}
	public int getNumberOfMineNeighbors() {
		return this.numberOfMineNeighbors;
	}
	
	public Tile toggleFlag() {
		this.isFlagged = !this.isFlagged;
		return this;
	}	
	public Tile reveal() {
		this.status = 'R';
		return this;
	}
	public Tile reset() {
		this.status = 'U';
		return this;
	}

}