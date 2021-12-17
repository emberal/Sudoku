package sudoku.board;

import JavaFX.JavaFXThreadingRule;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sudoku.control.SquareHandler;

public class SquareHandlerTest extends Application {

    SquareHandler square;

    @Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    @BeforeAll
    private static void javaFxSetup() {
        Platform.startup( () -> {});
    }

    private void setUp() {

    }

    @Test
    void SquareHandlerTest() {
        square = new SquareHandler(0, 0, 0);

        //int nr
        Assertions.assertNotNull(square);
        Assertions.assertNotEquals(2, square.getNr() );
        square.setNr(2);
        Assertions.assertEquals(2, square.getNr() );

        //boolean EDITABLE
        Assertions.assertTrue(square.isEditable() );

        //Label value
        Assertions.assertEquals("   " + square.getNr(), square.getValue().getText() );
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
