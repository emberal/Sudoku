package sudoku.board;

import javafx.application.Application;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sudoku.Main;

import java.util.Arrays;

public class BlockTest extends BoardTest { //TODO Tests

    Block block;

    private void setUp() {
        Main.launch();
        block = new Block(false, 0, 0, board);
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

    }

    @Test
    void existVerticallyTest() {

    }

    @Test
    void existTest() {
        setUp();

        block.setSquares(new Square[][] { {new Square(1), new Square(2)} });

        System.out.println(block);

        Assertions.assertTrue(block.exist(2) );
        Assertions.assertFalse(block.exist(3));
    }

}
