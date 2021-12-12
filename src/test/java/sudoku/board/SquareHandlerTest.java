package sudoku.board;

import javafx.application.Application;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sudoku.control.SquareHandler;

public class SquareHandlerTest extends BlockTest {

    SquareHandler square;

    @BeforeEach
    private void setUp() {
        Application.launch();
    }

    @Test
    void SquareHandlerTest() {
        square = new SquareHandler(0, 0, 0);
        Assertions.assertNotNull(square);
    }

}
