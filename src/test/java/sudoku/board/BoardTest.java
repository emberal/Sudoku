package sudoku.board;

import JavaFX.JavaFXThreadingRule;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

        board.getBoard()[0][0].setSquares(new Square[][]{
                {new Square(1),new Square(2),new Square(3)},
                {new Square(4),new Square(5),new Square(6)},
                {new Square(7),new Square(8),new Square(9)} });
        board.getBoard()[0][1].setSquares(new Square[][]{
                {new Square(7),new Square(8),new Square(9)},
                {new Square(1),new Square(2),new Square(3)},
                {new Square(4),new Square(5),new Square(6)} });
        board.getBoard()[0][2].setSquares(new Square[][]{
                {new Square(4),new Square(5),new Square(6)},
                {new Square(7),new Square(8),new Square(9)},
                {new Square(1),new Square(2),new Square(3)} });

        board.getBoard()[1][0].setSquares(new Square[][]{
                {new Square(3),new Square(1),new Square(2)},
                {new Square(6),new Square(4),new Square(5)},
                {new Square(9),new Square(7),new Square(8)} });
        board.getBoard()[1][1].setSquares(new Square[][]{
                {new Square(9),new Square(7),new Square(8)},
                {new Square(3),new Square(1),new Square(2)},
                {new Square(6),new Square(4),new Square(5)} });
        board.getBoard()[1][2].setSquares(new Square[][]{
                {new Square(6),new Square(4),new Square(5)},
                {new Square(9),new Square(7),new Square(8)},
                {new Square(3),new Square(1),new Square(2)} });

        board.getBoard()[2][0].setSquares(new Square[][]{
                {new Square(2),new Square(3),new Square(1)},
                {new Square(5),new Square(6),new Square(4)},
                {new Square(8),new Square(9),new Square(7)} });
        board.getBoard()[2][1].setSquares(new Square[][]{
                {new Square(8),new Square(9),new Square(7)},
                {new Square(2),new Square(3),new Square(1)},
                {new Square(5),new Square(6),new Square(4)} });
        board.getBoard()[2][2].setSquares(new Square[][]{
                {new Square(5),new Square(6),new Square(4)},
                {new Square(8),new Square(9),new Square(7)},
                {new Square(2),new Square(3),new Square(1)} });

        System.out.println(board);
    }

    @Test
    void toStringTest() {
        fullBoard();
        System.out.println(board);
    }

    @Test
    void isFinished() { //TODO
        fullBoard();

        Assertions.assertTrue(board.isFinished() );
    }

    @Test
    void completeHorizontalTest() { //TODO Test
        fullBoard();

        for (int i = 0; i < LEN_TOT; i++) {
            Assertions.assertTrue(board.completeHorizontal(i) );
        }

        for (int j = 0; j < LEN; j++) {
            for (int i = 0; i < LEN; i++) {
                board.getBoard()[j][i].getSquares()[j][i].setEditable(true);
                board.getBoard()[j][i].getSquares()[j][i].setNr(0);
            }
        }
        System.out.println(board);

        for (int i = 0; i < LEN_TOT; i++) {
            Assertions.assertFalse(board.completeHorizontal(i) );
        }
    }

    @Test
    void completeVerticalTest() { //TODO

    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
