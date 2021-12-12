package sudoku.board;

import javafx.application.Application;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import sudoku.gui.Interface;

public class JavaFXTest extends Application {

    @Test
    @Override
    public void start(Stage stage) throws Exception {
        Interface.start(stage);
    }
}
