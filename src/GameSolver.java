/**
 * Play a NumberGame and return the solution.
 * The NumberGame object must provide messages (getMessage)
 * containing the phrase "too small" if a guess is too small
 * and "too large" if a guess is too large, for efficient
 * solution.
 *
 * @param "game" is the Number to solve.
 * @return the solution and prints it out.
 * @author Thanapoom Rattanathumawat
 */

public class GameSolver {
    public int play(NumberGame game){

        int solution = 0;

        for(int i = 0;i < game.getUpperBound();i++){
            solution++;
           if(game.guess(i) == true){
               break;
           }
        }
        return solution;
    }
}
