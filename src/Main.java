/**
 * A main class for the GuessingGame.
 * It is responsible for creating objects, 
 * connecting objects, and running the game UI.
 */
public class Main {
	public static void main(String[] args) {
		// upper limit for secret number in guessing game
		int upperBound = 100;
		NumberGame game = new PoomGuessingGame(upperBound);
		GameSolver solve = new GameSolver();
		GameConsole ui = new GameConsole( );
		int solution = ui.play( game );
		/**
		 * The part below is to check if the class GameSolver works.
		 */
		int answer = solve.play(game);
		System.out.println("The answer is " + answer);
	}
}
