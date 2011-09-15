import java.util.Scanner;

public class MinesweeperClient_Console {
	public static Scanner _s;
	public Scanner s;
	
	public static void main(String[] args) {
		Minesweeper minesw = new Minesweeper();
	}
	// static functions	
	public static String _showMenu(String route) {
		_s = new Scanner(System.in);		
		
		if( route == "main") {
			System.out.println("GAME MENU:");
			System.out.println("==================================");
			System.out.println("1. New Game");			
			System.out.println("2. High Scores");
			System.out.println("X. Exit");
			
			System.out.print("Enter choice >> ");			
		}
		else {
		if( route ==  "submenu-newgame" ) {
			System.out.println("NEW GAME:");
			System.out.println("==================================");
			System.out.println("1. Easy (9x9, 10 mines)");
			System.out.println("2. Intermediate (16x16, 40 mines)");
			System.out.println("3. Professional (16x30, 99 mines)");			
			System.out.println("X. Back to Main");			
		}
		}
		
		return _s.nextLine();
	}	
}