package sudoku.board;

import JavaFX.JavaFXThreadingRule;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static sudoku.board.Board.LEN;

public class BlockTest extends Application { //TODO Tests

    Block block;

    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    private void javaFxSetup() {
        Platform.startup( () -> {});
    }

    private void setUp() {
        javaFxSetup();
        block = new Block(false, 0, 0, new Board(false));
    }

    private void fullBlock() {
        setUp();

        int i = 1;
        for (Square[] r : block.getSquares()) {
            for (Square c : r) {
                c.setNr(i);
                i++;
            }
        }
    }

    @Test
    void completeBlockTest() {
        setUp();
        fullBlock();

        System.out.println(block);
        Assertions.assertTrue(block.completeBlock() );
    }

    @Test
    void completeHorizontalTest() { //TODO Test
        setUp();

        block.getSquares()[0][1].setNr(2);
        block.getSquares()[0][2].setNr(3);

        Square[] squares = block.completeHorizontal(0);
        System.out.println(Arrays.toString(squares) );
        Assertions.assertNull(squares);

        fullBlock();
        squares = block.completeHorizontal(0);
        System.out.println(Arrays.toString(squares) );
        Assertions.assertNotNull(squares);

        block.getSquares()[0][1].setNr(0);
        block.getSquares()[1][1].setNr(0);
        block.getSquares()[2][1].setNr(0);

        squares = block.completeHorizontal(0);
        System.out.println(Arrays.toString(squares));
        Assertions.assertNull(squares);
    }

    @Test
    void completeVerticalTest() { //TODO Test
        setUp();

        Square[] squares = block.completeVertical(0);
        System.out.println(Arrays.toString(squares) );
        Assertions.assertNull(squares);

        fullBlock();
        squares = block.completeVertical(0);
        System.out.println(Arrays.toString(squares) );
        Assertions.assertNotNull(squares);
    }

    @Test
    void generateNrTest() {
        setUp();
        //TODO
    }

    @Test
    void existHorizontallyTest() {
        fullBlock();
        System.out.println(block);

        Assertions.assertFalse(block.existHorizontally(1,1) );

        for (int r = 0; r < LEN; r++) {
            for (int i = r * LEN + 1; i % LEN > 0; i++) {
                Assertions.assertTrue(block.existHorizontally(i, r) );
            }
        }
    }

    @Test
    void existVerticallyTest() {
        fullBlock();
        System.out.println(block);

        Assertions.assertFalse(block.existVertically(1,1) );

        for (int c = 0; c < LEN; c++) {
            for (int i = c + 1; i < c + 8; i += LEN) {
                Assertions.assertTrue(block.existVertically(i, c) );
            }
        }
    }

    @Test
    void existTest() {
        fullBlock();
        System.out.println(block);

        for (int i = 1; i <= 9; i++) {
            Assertions.assertTrue(block.exist(i) );
        }
        block.getSquares()[2][0].setNr(0);
        Assertions.assertFalse(block.exist(7) );
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
