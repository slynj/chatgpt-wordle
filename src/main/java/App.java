import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {

    private int count = 0;
    private Button[][] buttons;

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
            if (event.getCode() == KeyCode.A) {
                if (count < 25) {
                    buttons[count / 5][count % 5].setText("A");
                    count++;
                }
            }
            else if (event.getCode() == KeyCode.B) {
                if (count < 25) {
                    buttons[count / 5][count % 5].setText("B");
                    count++;
                }
            }
            // Add more else if statements for other letters
            else if (event.getCode() == KeyCode.C) {
                if (count < 25) {
                    buttons[count / 5][count % 5].setText("C");
                    count++;
                }
            }
            else if (event.getCode() == KeyCode.D) {
                if (count < 25) {
                    buttons[count / 5][count % 5].setText("D");
                    count++;
                }
            }

            else if (event.getCode() == KeyCode.E) {
                if (count < 25) {
                    buttons[count / 5][count % 5].setText("E");
                    count++;
                }
            }
            else if (event.getCode() == KeyCode.F) {
                if (count < 25) {
                    buttons[count / 5][count % 5].setText("F");
                    count++;
                }
            }
            else if (event.getCode() == KeyCode.G) {
                if (count < 25) {
                    buttons[count / 5][count % 5].setText("G");
                    count++;
                }
            }
            else if (event.getCode() == KeyCode.H) {
                if (count < 25) {
                    buttons[count / 5][count % 5].setText("H");
                    count++;
                }
            }
            else if (event.getCode() == KeyCode.I) {
                if (count < 25) {
                    buttons[count / 5][count % 5].setText("I");
                    count++;
                }
            }
            else if (event.getCode() == KeyCode.J) {
                if (count < 25) {
                    buttons[count / 5][count % 5].setText("J");
                    count++;
                }
            }
            else if (event.getCode() == KeyCode.K) {
                if (count < 25) {
                    buttons[count / 5][count % 5].setText("K");
                    count++;
                }
            }
            else if (event.getCode() == KeyCode.L) {
                if (count < 25) {
                    buttons[count / 5][count % 5].setText("L");
                    count++;
                }
            }
            else if (event.getCode() == KeyCode.M) {
                if (count < 25) {
                    buttons[count / 5][count % 5].setText("M");
                    count++;
                }
            }
            else if (event.getCode() == KeyCode.N) {
                if (count < 25) {
                    buttons[count / 5][count % 5].setText("N");
                    count++;
                }
            }
            else if (event.getCode() == KeyCode.O) {
                if (count < 25) {
                    buttons[count / 5][count % 5].setText("O");
                    count++;
                }
            }
            else if (event.getCode() == KeyCode.P) {
                if (count < 25) {
                    buttons[count / 5][count % 5].setText("P");
                    count++;
                }
            }

            else if (event.getCode() == KeyCode.Q) {
                if (count < 25) {
                    buttons[count / 5][count % 5].setText("Q");
                    count++;
                }
            }
            else if (event.getCode() == KeyCode.R) {
                if (count < 25) {
                    buttons[count / 5][count % 5].setText("R");
                    count++;
                }
            }
            else if (event.getCode() == KeyCode.S) {
                if (count < 25) {
                    buttons[count / 5][count % 5].setText("S");
                    count++;
                }
            }
            else if (event.getCode() == KeyCode.T) {
                if (count < 25) {
                    buttons[count / 5][count % 5].setText("T");
                    count++;
                }
            }
            else if (event.getCode() == KeyCode.U) {
                if (count < 25) {
                    buttons[count / 5][count % 5].setText("U");
                    count++;
                }
            }
            else if (event.getCode() == KeyCode.V) {
                if (count < 25) {
                    buttons[count / 5][count % 5].setText("V");
                    count++;
                }
            }
            else if (event.getCode() == KeyCode.W) {
                if (count < 25) {
                    buttons[count / 5][count % 5].setText("W");
                    count++;
                }
            }
            else if (event.getCode() == KeyCode.X) {
                if (count < 25) {
                    buttons[count / 5][count % 5].setText("X");
                    count++;
                }
            }
            else if (event.getCode() == KeyCode.Y) {
                if (count < 25) {
                    buttons[count / 5][count % 5].setText("Y");
                    count++;
                }
            }
            else if (event.getCode() == KeyCode.Z) {
                if (count < 25) {
                    buttons[count / 5][count % 5].setText("Z");
                    count++;
                }
            }

            
            if(count == 25){
                // Show a message to the user that the game is full
                javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Game is full");
                alert.setContentText("You have reached the maximum limit of letters, the game is now full.");
                alert.show();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
