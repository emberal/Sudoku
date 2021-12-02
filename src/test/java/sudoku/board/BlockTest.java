package sudoku.board;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BlockTest { //TODO Tests

    Block block;

    private void setUp() {
        block = new Block();
    }

    @Test
    void completeBlockTest() {
        setUp();

        int i = 1;
        for (int r = 0; r < block.getSquares().length; r++) {
            for (int c = 0; c < block.getSquares()[r].length; c++) {
                block.getSquares()[r][c].setNr(i);
                i++;
            }
        }

        Assertions.assertTrue(block.completeBlock() );
        System.out.println(block);
    }

    @Test
    void generateNrTest() {
        setUp();
        //TODO
    }

    @Test
    void existTest() {
        setUp();

        block.getSquares()[1][1].setNr(2);
        Assertions.assertTrue(block.exist(2) );
        Assertions.assertFalse(block.exist(1));
    }

}
