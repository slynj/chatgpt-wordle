import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.Random;


/**
 * TextWordle is a JavaFX application that implements a simple word guessing game.
 * The game randomly selects a word from a predefined list of words and the player
 * has to guess the word in 6 chances.
 */
public class TextWordle extends Application {
    int chancesLeft = 6; // Number of chances left for the player
    int randomIndex; // Index of the randomly selected word
    String randomWord; // The randomly selected word
    String[] words = {"apple", "table", "water", "green",   // List of words to choose from
                      "happy", "lemon", "storm", "smile", 
                      "ocean", "puzzle", "flower", "bloom", 
                      "sheep", "mouse", "peace", "stone", 
                      "watch", "swift", "yacht", "light", 
                      "beach", "blond", "bunch", "cloud", 
                      "crush", "dawns", "dwarf", "fable", 
                      "folly", "giant", "grasp", "heart", 
                      "hatch", "hilly", "hurry", "jolly", 
                      "jumbo", "kneel", "latch", "leapt", 
                      "lucky", "lyric", "misty", "moony", 
                      "myth", "nimble", "nurse", "petal", 
                      "punch", "quilt", "quirk", "quizz", 
                      "rapid", "rebel", "reign", "rusty", 
                      "scuba", "seize", "shank", "slate", 
                      "sleek", "slink", "slate", "smile", 
                      "smirk", "smoky", "spend", "spicy", 
                      "spoon", "spurs", "squad", "squid", 
                      "stale", "steep", "sting", "stork", 
                      "swoop", "tulip"}; 
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Random random = new Random();
        randomIndex = random.nextInt(words.length);
        randomWord = words[randomIndex];

        GridPane root = new GridPane();
        root.setHgap(10); // horizontal gap between elements
        root.setVgap(10); // vertical gap between elements
        root.setPadding(new Insets(10)); // padding around the grid
        
        // Label for displaying the word to guess
        Label wordLabel = new Label("Word:");
        root.add(wordLabel, 0, 0);

        // Text field for inputting the guess
        TextField wordField = new TextField();
        wordField.setPrefSize(100, 20);
        wordField.setEditable(true);
        wordField.setDisable(false);
        wordField.setPromptText("Enter a 5 letter word");
        wordField.requestFocus();
        wordField.setTextFormatter(new TextFormatter<String>(change -> {
            if (change.getControlNewText().length() > 5) {
                return null;
            }
            return change;
        }));
        wordField.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (wordField.getText().length() >= 5) {
                event.consume();
            }
        });

        root.add(wordField, 1, 0);

        // Label for displaying the number of chances left
        Label scoreLabel = new Label("Chances left: " + chancesLeft);
        root.add(scoreLabel, 0, 1);

        // Button for getting a new word
        Button newWordButton = new Button("New Word");
        root.add(newWordButton, 2, 1);
        // Button for submitting the guess
        Button submitButton = new Button("Submit");
        root.add(submitButton, 1, 1);

        // Action Listener for the new word button
        newWordButton.setOnAction(event -> {
            randomIndex = random.nextInt(words.length);
            randomWord = words[randomIndex];
            wordField.clear();
            chancesLeft = 6;
            scoreLabel.setText("Chances left: " + chancesLeft);
            submitButton.setDisable(false);
        });
        
        // Action Listener for the submit button
        submitButton.setOnAction(event -> {
            String inputWord = wordField.getText();
            if (inputWord.length() < 5) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Invalid Input");
                alert.setContentText("Enter a 5 letter word");
                alert.showAndWait();
            } else if (inputWord.equalsIgnoreCase(randomWord)) {
                // show message dialog for correct answer
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Correct");
                alert.setHeaderText("Correct");
                alert.setContentText("Congratulations, you guessed the word correctly!");
                alert.showAndWait();
                newWordButton.setVisible(true);
                newWordButton.fire();
            } else {
                chancesLeft--;
                scoreLabel.setText("Chances left: " + chancesLeft);
                if (chancesLeft == 0) {
                    // end the game
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Game Over");
                    alert.setHeaderText("Game Over");
                    alert.setContentText("Game Over, the correct word is "+randomWord);
                    alert.showAndWait();
                    submitButton.setDisable(true);
                    newWordButton.fire();
                }
            }
        });

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        // Add event filter to handle enter key press
        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ENTER) {
                submitButton.fire();
            }
        });

        stage.setScene(scene);
        stage.setTitle("Wordle Game");
        stage.show();
    }
}

