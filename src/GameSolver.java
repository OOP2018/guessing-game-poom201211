/**
 * This class is created to solve the solution of any guessing game.
 *
 * @author Thanapoom Rattanathumawat
 */

public class GameSolver {
    /**
     * Play a NumberGame and return the solution.
     * The NumberGame object must provide messages (getMessage)
     * containing the phrase "too small" if a guess is too small
     * and "too large" if a guess is too large, for efficient
     * solution.
     *
     * @param "game" is the Number to solve.
     * @return the solution and prints it out.
     */
    public int play(NumberGame game){

        int max = game.getUpperBound();
        int min = 1;
        int solution = 0;

        while(true){
            int range = (max - min) + 1;
            int guessNumber = (int)((Math.random()*range) + min);
            game.guess(guessNumber);
            String hint = game.getMessage();
            if(hint.contains("large")){
                max = guessNumber;
            }
            else if(hint.contains("small")){
                min = guessNumber;
            }
            else if(hint.contains("Correct")){
                solution = guessNumber;
                break;
            }
        }
        return solution;
    }
}
