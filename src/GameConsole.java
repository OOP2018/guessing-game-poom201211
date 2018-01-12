import java.util.Scanner;

/** 
 *  Play guessing game on the console.
 */

public class GameConsole {

	/** play the game. */
	public int play(NumberGame game) {
		Scanner console = new Scanner(System.in);
		int guess = 0;
		
		// describe the game
		System.out.println( game.toString() );
		
		// This is just an example.
		while(true){
			System.out.println( game.getMessage() );
			System.out.print("\nYour answer? ");
			guess = console.nextInt();
			boolean correct = game.guess(guess);
			System.out.println("Number of guesses: "+game.getCount());
			if(correct){
				break;
			}
		}
		System.out.println( game.getMessage() );
		return guess;
	}
	
}

