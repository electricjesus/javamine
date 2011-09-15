import java.util.Random;

public class Tileset {
	private int height, width, numMines;		
	private Tile[] tiles;
	Tileset () {		
		this(9, 9, 10); //default size is 9x9 and 10 mines
	}
	Tileset (int height, int width, int numMines) {
		this.height = height; this.width = width; this.numMines = numMines;
		int seeds[] = _createSeededData(this.height, this.width, 10);
		
		tiles = new Tile[height*width];		
		for(int i = 0; i < tiles.length; i++ ) {
			tiles[i] = new Tile( seeds[i]==1 ? 'M':'N' );
		}
	}
	public int getHeight() 		{	return this.height; 	}
	public int getWidth() 		{	return this.width; 		}
	public int getNumMines() 	{	return this.numMines; 	}
	
	public Tileset setHeight( int _param ) {	this.height = _param; return this;  }
	public Tileset setWidth ( int _param ) {	this.width  = _param; return this;  }
	public Tileset setNumMines( int _param ) {	this.numMines = _param; return this;  }
	
	
	public static int[] _createSeededData(int height, int width, int numMines) {		
		int minesLeft = numMines;
		int length = height*width;		
		Random randGen = new Random();
		int seeds[] = new int[length];		
		for(int i = 0; i < 10; i ++) {
			int location = randGen.nextInt(length);
			if(seeds[location] == 1) location = randGen.nextInt(length); // check for collision and generate again, only called once since another collision is less likely.
			seeds[location] = 1;
		}
		for(int i = 0; i < seeds.length; i++) if(seeds[i] != 1) seeds[i] = 0;			
		return seeds;
	}
	public String toString() {		
		return "";		
	}
	public void revealAllTiles() {
		for(int i = 0; i < tiles.length; i++)
			tiles[i].reveal();
	}
	public void resetAllTiles() {
		for(int i = 0; i < tiles.length; i++)
			tiles[i].reset();
	}
}