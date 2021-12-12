package sudoku.board;

import javafx.application.Application;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static sudoku.board.Board.LEN;
import static sudoku.board.Board.LEN_TOT;

public class BoardTest extends JavaFXTest {

    Board board;

    private void setUp() {
        board = new Board(false); //FIXME Generates exception!!
    }

    private void fullBlock() { //TODO Test
        setUp();

        for (Block[] r : board.getBoard()) {
            for (Block c : r) {
                int i = 1;
                for (int j = 0; j < LEN; j++) {
                    for (int k = 0; k < LEN; k++) {
                        c.getSquares()[j][k].setNr(i);
                        i++;
                    }
                }
            }
        }
    }

    @Test
    void isFinished() { //TODO

    }

    @Test
    void completeHorizontalTest() { //TODO Test
        setUp();

        Assertions.assertTrue(board.completeHorizontal(1));
    }

    @Test
    void completeVerticalTest() { //TODO

    }

}
