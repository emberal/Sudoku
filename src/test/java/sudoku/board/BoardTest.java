package sudoku.board;

import JavaFX.JavaFXThreadingRule;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sudoku.control.SquareHandler;

import static sudoku.board.Board.LEN;

public class BoardTest extends Application {

    Board board;

    @Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    private void javaFxSetup() {
        Platform.startup( () -> {});
    }

    private void setUp() {
        javaFxSetup();
        board = new Board(false);
    }

    public void fullBoard() { //TODO Setup board so the game is complete!
        setUp();

        board.setBoard(new Block[][]{
                {new Block(false,0,0, board), new Block(false,0,1, board), new Block(false,0,2, board)},
                {new Block(false,1,0, board), new Block(false,1,1, board), new Block(false,1,2, board)},
                {new Block(false,2,0, board), new Block(false,2,1, board), new Block(false,2,2, board)} });

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
        System.out.println(board);
    }

    @Test
    void isFinished() { //TODO

    }

    @Test
    void completeHorizontalTest() { //TODO Test
        fullBoard();
        System.out.println(board);
        Assertions.assertTrue(board.completeHorizontal(1));
        Assertions.assertTrue(
                board.getBoard()[0][0].existHorizontally(1, 1) ||
                board.getBoard()[0][1].existHorizontally(1, 1) ||
                board.getBoard()[0][2].existHorizontally(1, 1) );
    }

    @Test
    void completeVerticalTest() { //TODO

    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
