package sudoku.gui;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public abstract class Interface {

    private static final BorderPane PANE = new BorderPane();

    public static void start(Stage stage) {
        stage.setTitle("Sudoku");

        Scene scene = new Scene(PANE, 1000, 500); //TODO window size
        stage.setScene(scene);
        stage.show();
    }

}
