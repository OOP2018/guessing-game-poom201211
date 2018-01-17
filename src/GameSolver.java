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

        boolean correct;
        int bound;
        int max = game.getUpperBound();
        int min = 1;

        do {
            bound = min + (max - min) / 2;

            correct = game.guess(bound);

            String message = game.getMessage();

            if (message.contains("small")) {
                min = bound + 1;
            } else if (message.contains("large")) {
                max = bound - 1;
            }

        } while (!correct);
        return bound;
    }
}
