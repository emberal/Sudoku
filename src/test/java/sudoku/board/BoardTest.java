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

import static sudoku.board.Board.LEN;
import static sudoku.board.Board.LEN_TOT;

public class BoardTest extends Application {

    Board board;

    @Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    @BeforeAll
    public static void javaFxSetup() {
        Platform.startup( () -> {});
    }

    private void setUp() {
        board = new Board(false);
    }

    public void fullBoard() { //TODO change to series of loops...
        setUp();

        board.getBoard()[0][0].setSquares(new SquareHandler[][]{
                {new SquareHandler(1,0,0,board),new SquareHandler(2,0,1,board),new SquareHandler(3,0,2,board)},
                {new SquareHandler(4,1,0,board),new SquareHandler(5,1,1,board),new SquareHandler(6,1,2,board)},
                {new SquareHandler(7,2,0,board),new SquareHandler(8,2,1,board),new SquareHandler(9,2,2,board)} });
        board.getBoard()[0][1].setSquares(new SquareHandler[][]{
                {new SquareHandler(7,0,3,board),new SquareHandler(8,0,4,board),new SquareHandler(9,0,5,board)},
                {new SquareHandler(1,1,3,board),new SquareHandler(2,1,4,board),new SquareHandler(3,1,5,board)},
                {new SquareHandler(4,2,3,board),new SquareHandler(5,2,4,board),new SquareHandler(6,2,5,board)} });
        board.getBoard()[0][2].setSquares(new SquareHandler[][]{
                {new SquareHandler(4,0,6,board),new SquareHandler(5,0,7,board),new SquareHandler(6,0,8,board)},
                {new SquareHandler(7,1,6,board),new SquareHandler(8,1,7,board),new SquareHandler(9,1,8,board)},
                {new SquareHandler(1,2,6,board),new SquareHandler(2,2,7,board),new SquareHandler(3,2,8,board)} });

        board.getBoard()[1][0].setSquares(new SquareHandler[][]{
                {new SquareHandler(3,3,0,board),new SquareHandler(1,3,1,board),new SquareHandler(2,3,2,board)},
                {new SquareHandler(6,4,0,board),new SquareHandler(4,4,1,board),new SquareHandler(5,4,2,board)},
                {new SquareHandler(9,5,0,board),new SquareHandler(7,5,1,board),new SquareHandler(8,5,2,board)} });
        board.getBoard()[1][1].setSquares(new SquareHandler[][]{
                {new SquareHandler(9,3,3,board),new SquareHandler(7,3,4,board),new SquareHandler(8,3,5,board)},
                {new SquareHandler(3,4,3,board),new SquareHandler(1,4,4,board),new SquareHandler(2,4,5,board)},
                {new SquareHandler(6,5,3,board),new SquareHandler(4,5,4,board),new SquareHandler(5,5,5,board)} });
        board.getBoard()[1][2].setSquares(new SquareHandler[][]{
                {new SquareHandler(6,3,6,board),new SquareHandler(4,3,7,board),new SquareHandler(5,3,8,board)},
                {new SquareHandler(9,4,6,board),new SquareHandler(7,4,7,board),new SquareHandler(8,4,8,board)},
                {new SquareHandler(3,5,6,board),new SquareHandler(1,5,7,board),new SquareHandler(2,5,8,board)} });

        board.getBoard()[2][0].setSquares(new SquareHandler[][]{
                {new SquareHandler(2,6,0,board),new SquareHandler(3,6,1,board),new SquareHandler(1,6,2,board)},
                {new SquareHandler(5,7,0,board),new SquareHandler(6,7,1,board),new SquareHandler(4,7,2,board)},
                {new SquareHandler(8,8,0,board),new SquareHandler(9,7,1,board),new SquareHandler(7,8,2,board)} });
        board.getBoard()[2][1].setSquares(new SquareHandler[][]{
                {new SquareHandler(8,6,3,board),new SquareHandler(9,6,4,board),new SquareHandler(7,6,5,board)},
                {new SquareHandler(2,7,3,board),new SquareHandler(3,7,4,board),new SquareHandler(1,7,5,board)},
                {new SquareHandler(5,8,3,board),new SquareHandler(6,8,4,board),new SquareHandler(4,8,5,board)} });
        board.getBoard()[2][2].setSquares(new SquareHandler[][]{
                {new SquareHandler(5,6,6,board),new SquareHandler(6,6,7,board),new SquareHandler(4,6,8,board)},
                {new SquareHandler(8,7,6,board),new SquareHandler(9,7,7,board),new SquareHandler(7,7,8,board)},
                {new SquareHandler(2,8,6,board),new SquareHandler(3,8,7,board),new SquareHandler(1,8,8,board)} });

        System.out.println(board);
    }

    @Test
    void toStringTest() {
        fullBoard();
    }

    @Test
    void isFinished() {
        fullBoard();

        Assertions.assertTrue(board.isFinished() );

        board.getBoard()[2][2].getSquares()[1][1].setEditable(true);
        board.getBoard()[2][2].getSquares()[1][1].setNr(0);

        Assertions.assertFalse(board.isFinished() );
    }

    @Test
    void completeHorizontalTest() { //TODO Test
        fullBoard();

        for (int i = 0; i < LEN_TOT; i++) {
            Assertions.assertTrue(board.completeHorizontal(i) );
        }

        for (int j = 0; j < LEN; j++) {
            for (int i = 0; i < LEN; i++) {
                board.getBoard()[j][i].getSquares()[i][j].setEditable(true);
                board.getBoard()[j][i].getSquares()[i][j].setNr(0);
            }
        }
        System.out.println(board);

        for (int i = 0; i < LEN_TOT; i++) {
            Assertions.assertFalse(board.completeHorizontal(i) );
        }
    }

    @Test
    void completeVerticalTest() { //TODO
        fullBoard();

        for (int i = 0; i < LEN_TOT; i++) {
            Assertions.assertTrue(board.completeVertical(i) );
        }

        for (int j = 0; j < LEN; j++) {
            for (int i = 0; i < LEN; i++) {
                board.getBoard()[j][i].getSquares()[i][j].setEditable(true);
                board.getBoard()[j][i].getSquares()[i][j].setNr(0);
            }
        }
        System.out.println(board);

        for (int i = 0; i < LEN_TOT; i++) {
            Assertions.assertFalse(board.completeVertical(i) );
        }
    }

    @Test
    void existHorizontallyTest() {
        fullBoard();

        for (int r = 0; r < LEN_TOT; r++) {
            for (int i = 1; i <= 9; i++) {
                Assertions.assertTrue(board.existHorizontally(i, r) );
            }
        }
    }

    @Test
    void existVerticallyTest() {
        fullBoard();

        for (int v = 0; v < LEN_TOT; v++) {
            for (int i = 1; i <= 9; i++) {
                Assertions.assertTrue(board.existVertically(i, v) );
            }
        }
    }

    @Test
    void getDuplicateHorizontallyTest() {
        fullBoard();

        Assertions.assertNull(board.dupeHorizontal(board.getBoard()[0][0].getSquares()[0][0]));

        int n = 9;
        for (int i = 0; i < LEN; i++) {
            for (int j = 0; j < LEN; j++) {
                board.getBoard()[i][j].getSquares()[j][j].setEditable(true);
                board.getBoard()[i][j].getSquares()[j][j].setNr(n);
                n--;
            }
        }
        System.out.println(board);

        Assertions.assertEquals(9, board.dupeHorizontal(board.getBoard()[0][1].getSquares()[0][2]).getNr());
        Assertions.assertEquals(5, board.dupeHorizontal(board.getBoard()[1][0].getSquares()[1][2]).getNr());
        Assertions.assertEquals(2, board.dupeHorizontal(board.getBoard()[2][1].getSquares()[1][0]).getNr());
    }

    @Test
    void getDuplicateVerticallyTest() {
        fullBoard();

        Assertions.assertNull(board.dupeVertical(board.getBoard()[0][0].getSquares()[0][0]));

        int n = 9;
        for (int i = 0; i < LEN; i++) {
            for (int j = 0; j < LEN; j++) {
                board.getBoard()[j][i].getSquares()[j][j].setEditable(true);
                board.getBoard()[j][i].getSquares()[j][j].setNr(n);
                n--;
            }
        }
        System.out.println(board);

        Assertions.assertEquals(9, board.dupeVertical(board.getBoard()[1][0].getSquares()[2][0]).getNr());
        Assertions.assertEquals(5, board.dupeVertical(board.getBoard()[0][1].getSquares()[2][1]).getNr());
        Assertions.assertEquals(2, board.dupeVertical(board.getBoard()[1][2].getSquares()[1][1]).getNr());
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
