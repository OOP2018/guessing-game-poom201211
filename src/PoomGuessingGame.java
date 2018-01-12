import java.util.Random;

public class PoomGuessingGame extends NumberGame {

    private int upperBound;

    private int secret;

    private int count;

    public PoomGuessingGame (int upperbound){
        this.upperBound = upperbound;
        long seed = System.nanoTime();
        Random secretNum = new Random(seed);
        this.secret = secretNum.nextInt(100) + 1;
        System.out.printf("I'm thinking of a number between 1 and %d.\n",upperbound);
    }

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

    public int getUpperBound(){
        return upperBound;
    }

    public int getCount(){
        return count;
    }

    public String toString(){ return "Guess a secret number between 1 and 100."; }

}
