package sudoku.board;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static sudoku.board.Utils.existHorizontally;
import static sudoku.board.Utils.existVertically;

public class UtilsTest extends BoardTest {

    @BeforeEach
    public void setUp() {

    }

    @Test
    void existHorizontallyTest() {
        fullBoard();

        Assertions.assertTrue(existHorizontally(board, 6, 1) );
        Assertions.assertFalse(existHorizontally(board, 5, 2) );
    }

    @Test
    void existVerticallyTest() {
        fullBoard();

        Assertions.assertTrue(existVertically(board, 4, 3) );
        Assertions.assertFalse(existVertically(board, 7, 5) );
    }
}
