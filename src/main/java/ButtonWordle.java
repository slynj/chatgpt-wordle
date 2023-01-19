import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ButtonWordle extends Application {

    private int count = 0;
    private Button[][] buttons;
    int line = 0;
    int currentRow = 0;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Wordle Game");

        // Create the grid pane
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Create the buttons
        buttons = new Button[5][5];
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                buttons[row][col] = new Button();
                buttons[row][col].setMinSize(50, 50);
                buttons[row][col].setMaxSize(50, 50);
                gridPane.add(buttons[row][col], col, row);
            }
        }

        

        Scene scene = new Scene(gridPane, 400, 400);
        scene.setOnKeyPressed(event -> {
            String[] alphabets = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
            if (event.getCode().isLetterKey()) {
                String key = event.getCode().toString();
                key = key.substring(key.lastIndexOf("_") + 1);
                for (int i = 0; i < alphabets.length; i++) {
                    if (key.equalsIgnoreCase(alphabets[i])) {
                        if (count % 5 < 5) {
                            buttons[currentRow][count % 5].setText(key);
                            count++;
                        }
                    }
                }
            } else if (event.getCode() == KeyCode.BACK_SPACE) {
                if (count % 5 > 0) {
                    buttons[currentRow][(count - 1) % 5].setText("");
                    count--;
                }
            } else if (event.getCode() == KeyCode.ENTER) {
                if (count % 5 == 5) {
                    currentRow++;
                    for (int i = 0; i < 5; i++) {
                        buttons[currentRow - 1][i].setDisable(true);
                    }
                }
            }
            // Check if all the rows are filled and show a message to the user
            if (count == 25) {
                javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Game is full");
                alert.setContentText("You have reached the maximum limit of letters, the game is now full.");
                alert.showAndWait();
            }


        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }
     
}