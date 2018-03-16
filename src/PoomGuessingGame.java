import java.util.Random;
/**
 * This is a guessing game with an upperbound of 100 from 0, with the
 * addition of a counting system for each guess.
 *
 * @author Thanapoom Rattanathumawat
 * @version 2018.01.11
 */

public class PoomGuessingGame extends NumberGame {
    //Upperbound of the secret number
    private int upperBound;
    //The solution
    private int secret;
    //Counts the number of guesses
    private int count;

    /**
     * This is the constructor for the default game
     * @param upperbound entered by user
     */
    public PoomGuessingGame(int upperbound){
        this.upperBound = upperbound;
        long seed = System.nanoTime();
        Random secretNum = new Random(seed);
        this.secret = secretNum.nextInt(this.upperBound) + 1;
        setMessage(String.format("I'm thinking of a number between 1 and %d.",upperbound));
    }

    /**
     * This method evaluates the players guesses
     * @param number
     * @return boolean true or false
     */
    public boolean guess(int number){
        if (number == secret) {
            setMessage("Correct! The value is "+secret);
            count++;
            return true;
        }

        else if (number < secret) {
            setMessage("Your answer is too small.");
            count++;
            return false;
        }

        else /* if (number > secret) */ {
            setMessage("Your answer is too large.");
            count++;
        }
        return false;
    }

    /**
     * Gets the upperboud of the game
     * @return upperbound of the default game
     */
    public int getUpperBound(){
        return upperBound;
    }

    /**
     * Gets the number of guesses and returns them
     * @return the number of guesses
     */
    public int getCount(){
        return count;
    }

    @Override
    public String toString(){ return String.format("Guess a secret number between 1 and %d.", getUpperBound()); }

}
