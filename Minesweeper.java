import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;

public class Minesweeper implements ActionListener {
	public int runningTime; 
	public char status;			// R = running, X = stopped
	private Tileset tileset;
	private Timer timer;
	
	Minesweeper() {
		this(9,9,10);
	}
	Minesweeper(int height, int width, int numMines) {
		NewGame(height, width, numMines);
	}
	
	public void NewGame(boolean samegame) { //loltest
		//reset game
		this.runningTime = 0;
		this.status = 'X'; // always start stopped until user does something		
		//reset tiles
		tileset.resetAllTiles();
		NewGame(tileset.getHeight(), tileset.getWidth(), tileset.getNumMines());
	}	
	
	public void actionPerformed (java.awt.event.ActionEvent e) {
		System.out.println("Action performed");
	}
	
	public void NewGame(int height, int width, int numMines) {
		timer = new Timer(1000, new ActionListener() { 				
				public void actionPerformed (java.awt.event.ActionEvent e) {
					System.out.println("Action performed 2");
				}
		});
		//timer.stop(); // stop immediately		
	}	
	
	public void StartClock() {
		if(this.status == 'X') {
			this.status = 'R';
			//run clock
			//timer.start();
		}
		else {
			System.out.println("Clock already running!");
		}		
	}
	
	public void StopClock(boolean gameend) {
			//stop game clock
			this.status = 'X';
			timer.stop();
			// if game end, execute other actions here..
			if(gameend) {
				// some stuff.
			}
	}
	
	// game events.. usually void
	public void Think() {
		// called periodically every clock tick..
		// nothing to do here YET
	}
	// called when user final clicks a tile
	public void ClearTile( Tile theTile ) {
		
		if(theTile.getTileType() != 'M') { //not a mine
			if(theTile.getNumberOfMineNeighbors() == 0) {
				//reveal
				//
				Tile[] neighbors = theTile.getNeighbors();
				for(int i = 0; i < neighbors.length; i++)
					ClearTile(neighbors[i]);
			} else {
				//reveal all
				tileset.revealAllTiles();
				//then end the game.. game over
				EndGame(false);				
			}
		}
	}
	// 
	public void EndGame(boolean win) {
		this.status = 'X';
		if(win) {
			//do win stuff here
		}
	}
	public int CoordsToIndex( int tilex, int tiley ) {
		return 1;
	}
	
	
	
	
}