import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Observable;

public class LastGuessView implements java.util.Observer{
    /** the stage (top-level window) for showing scene */
    private Stage stage;
    /** a counter to show value of */
    private PoomGuessingGame guess;
    /** the label that shows the counter value. */
    private Label label;

    /**
     * Initialize a CounterView, which shows value of a counter.
     * @param guess the Counter to show.
     */
    public LastGuessView(PoomGuessingGame guess) {
        this.guess = guess;
        initComponents();
    }

    private void initComponents() {
        stage = new Stage();
        // components and containers for our window
        HBox root = new HBox();
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);
        // The label that will show the counter value.
        label = new Label("   ");
        // make the label big enough
        label.setPrefWidth(300);
        label.setFont(new Font("Arial", 60.0));
        label.setAlignment(Pos.CENTER);
        // Add the label to the HBox.  You can all more components, too.
        root.getChildren().add(label);
        // Create a Scene using HBox as the root element
        Scene scene = new Scene(root);
        // show the scene on the stage
        stage.setScene(scene);
        stage.setTitle("Previous Guess");
        stage.sizeToScene();
    }

    /** Show the window and update the counter value. */
    public void run() {
        stage.show();
        displayGuess();
    }

    public void displayGuess() {
        label.setText( String.format("%2d", guess.getLastGuess()) );
    }

    // Closes this stage
    public void stop(){
        stage.close();
    }

    @Override
    public void update(Observable o, Object arg) {
        displayGuess();
    }
}
