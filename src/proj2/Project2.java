/**
 * This is the driver class for the card game War
 * Class Invariants: None
 * @version 10/7/2012
 * @author Susan Mitchell <smitchel@csee.umbc.edu>
 * @project CMSC 202 - Fall 2012 - Project 2
 * @section N/A
 */

package proj2;
import java.util.Scanner;

public class Project2 {
	
	public static void main( String[ ] args)
	{
		Scanner keybd = new Scanner( System.in );
		
		// Get player names
		System.out.println("Welcome to WAR!!");
		System.out.print("Please enter player 1's name: ");
		String p1Name = keybd.nextLine();
		System.out.print("Please enter player 2's name: ");
		String p2Name = keybd.nextLine();

		// Get random number generator (RNG) seed and initialize the game
		System.out.print ("Please enter the RNG seed for shuffling: ");
		long rngSeed = keybd.nextLong();
		Game war = new Game(p1Name, p2Name, rngSeed);
		int turn = 1;
		
		// While game is being played, print details and results of each turn
		while (!war.gameComplete())
		{
			System.out.printf( "Turn %2d\n", turn);
			System.out.println( "-----");
			System.out.println( war.nextTurn());
			++turn;
		}
		
		// All turns complete; print the game results
		System.out.println("Game Over!!");
		System.out.println(war.gameResult());
	}
}