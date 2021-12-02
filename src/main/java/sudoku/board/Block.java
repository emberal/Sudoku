package sudoku.board;

import java.util.Random;

/*
 * Array[][] containing all squares in a 3x3 area
 * Should be able to represent a board with 9 objects
 * Should check if all the numbers in the block, are unique
 */

public class Block { //TODO Tests

    private Square[][] squares;

    /**
     * Constructs a block with 9 squares, randomly generates a number
     */

    public Block() {
        squares = new Square[3][3];

        for (int r = 0; r < squares.length; r++) {
            for (int k = 0; k < squares[r].length; k++) {
                squares[r][k] = new Square(generateNr() );
            }
        }
    }

    /**
     * Generates a random number between 1-9 if a Random boolean is true.
     * If the number already exists in the block, the new number is tossed
     * @return int
     */

    public int generateNr() {
        int nr = -1;
        Random r = new Random();

        if (r.nextBoolean() ) {
            nr = r.nextInt(9) + 1;
            if (exist(nr) ) {
                nr = -1;
            }
        }
        return nr;
    }

    /**
     * Return true, if all numbers 1-9 are present
     * @return boolean
     */

    public boolean completeBlock() {

        boolean complete = true;

        for (int i = 1; i <= 9; i++) {
            if (!exist(i) ) {
                complete = false;
            }
        }
        return complete;
    }

    /**
     * Returns the first complete vertical line
     * @return Square[]
     */

    public Square[] completeVertical() { //TODO
        return null;
    }

    /**
     * Returns the first complete horizontal line
     * @return Square[]
     */

    public Square[] completeHorizontal() { //TODO
       return null;
    }

    public boolean exist(int nr) {

        for (Square[] r : squares) {
            for (Square c : r) {
                if (c != null && c.getNr() == nr) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder block = new StringBuilder();

        for (Square[] r : squares) {
            for (Square s : r) {
                block.append(s);
            }
            block.append("\n");
        }
        block.append("\n");
        return block.toString();
    }

    public Square[][] getSquares() {
        return squares;
    }

}
