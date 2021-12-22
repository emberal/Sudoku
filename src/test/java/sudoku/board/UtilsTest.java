package sudoku.board;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static sudoku.board.Board.LEN_TOT;
import static sudoku.board.Utils.existHorizontally;
import static sudoku.board.Utils.existVertically;

public class UtilsTest extends BoardTest {

    @BeforeEach
    public void setUp() {

    }

    @Deprecated
    @Test
    void existHorizontallyTest() {
        fullBoard();

        for (int r = 0; r < LEN_TOT; r++) {
            for (int i = 1; i <= 9; i++) {
                Assertions.assertTrue(existHorizontally(board, i, r) );
            }
        }
    }

    @Deprecated
    @Test
    void existVerticallyTest() {
        fullBoard();

        for (int v = 0; v < LEN_TOT; v++) {
            for (int i = 1; i <= 9; i++) {
                Assertions.assertTrue(existVertically(board, i, v) );
            }
        }
    }
}
