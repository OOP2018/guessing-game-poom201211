import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class GuessingController{
    @FXML
    TextField textfield;
    @FXML
    Label label1;
    @FXML
    Label label2;
    // Initializing class CounterView
    private CounterView cv;
    // Initializing class LastGuessView
    private LastGuessView lgv;

    private PoomGuessingGame p;

    public void handleGuess(ActionEvent event) {
        try {
            int text = Integer.parseInt(textfield.getText().trim());
            p.guess(text);
            label1.setText(p.getMessage());
            label1.setStyle("-fx-text-fill: black;");
            label2.setText("Total guess: " + p.getCount() + "");
            cv.displayCount();
            lgv.displayGuess();
        }catch (NumberFormatException nfe){
            textfield.setText("Invalid input");
            textfield.setStyle("-fx-text-fill: red;");
        }
    }

    public void handleClear(ActionEvent event){
        textfield.setText("");
        textfield.setStyle("-fx-text-fill: black;");

    }

    public void newGame(){
        cv.stop();
        lgv.stop();
        textfield.setText("");
        textfield.setStyle("-fx-text-fill: black;");
        label1.setText("");
        label2.setText("");
        p = new PoomGuessingGame(100);
        cv = new CounterView(p);
        cv.run();
        lgv = new LastGuessView(p);
        lgv.run();
    }

    public void initialize(){
        p = new PoomGuessingGame(100);
        cv = new CounterView(p);
        cv.run();
        lgv = new LastGuessView(p);
        lgv.run();
    }
}
