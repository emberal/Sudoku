package sudoku.board;

import JavaFX.JavaFXThreadingRule;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static sudoku.board.Board.LEN;

public class BlockTest extends Application { //TODO Tests

    Block block;

    @Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    @BeforeAll
    private static void javaFxSetup() {
        Platform.startup( () -> {});
    }

    private void setUp() {
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
        System.out.println(block);
    }

    @Test
    void completeBlockTest() {
        fullBlock();

        System.out.println(block);
        Assertions.assertTrue(block.completeBlock() );
    }

    @Test
    void completeHorizontalTest() {

        fullBlock();

        for (int i = 0; i < LEN; i++) {
            Square[] hor = block.completeHorizontal(i);
            Assertions.assertNotNull(hor);
            for (int j = 0; j < LEN; j++) {
                Assertions.assertTrue(hor[j].getNr() != 0);
                Assertions.assertEquals(j+1 + i*3, hor[j].getNr() );
            }
        }

        for (int i = 0; i < LEN; i++) {
            block.getSquares()[i][i].setNr(0);
        }
        System.out.println(block);

        for (int i = 0; i < LEN; i++) {
            Square[] hor = block.completeHorizontal(i);
            Assertions.assertNull(hor);
        }
    }

    @Test
    void completeVerticalTest() {

        fullBlock();

        for (int i = 0; i < LEN; i++) {
            Square[] ver = block.completeVertical(i);
            Assertions.assertNotNull(ver);
            for (int j = 0; j < LEN; j++) {
                Assertions.assertTrue(ver[j].getNr() != 0);
                Assertions.assertEquals(j*3+1+i, ver[j].getNr() );
            }
        }

        for (int i = 0; i < LEN; i++) {
            block.getSquares()[i][i].setNr(0);
        }
        System.out.println(block);

        for (int i = 0; i < LEN; i++) {
            Square[] hor = block.completeVertical(i);
            Assertions.assertNull(hor);
        }
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