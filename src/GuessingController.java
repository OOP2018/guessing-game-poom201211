import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class GuessingController {
    @FXML
    TextField textfield;
    @FXML
    Label label1;
    @FXML
    Label label2;

    private NumberGame p;

    public void handleGuess(ActionEvent event) {
        try {
            int text = Integer.parseInt(textfield.getText().trim());
            p.guess(text);
            label1.setText(p.getMessage());
            label2.setText("Total guess: " + p.getCount() + "");
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
        textfield.setText("");
        textfield.setStyle("-fx-text-fill: black;");
        label1.setText("");
        label2.setText("");
        p = new PoomGuessingGame(100);
    }

    public void initialize(){
        p = new PoomGuessingGame(100);
    }
}
