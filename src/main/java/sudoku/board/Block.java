package sudoku.board;

import java.util.Random;

public class Block {

    private Square[][] squares;

    public Block() {
        squares = new Square[3][3];

        for (int r = 0; r < squares.length; r++) {
            for (int k = 0; k < squares[r].length; k++) {
                squares[r][k] = new Square(generateNr() );
            }
        }
    }

    public byte generateNr() {
        byte nr = -1;
        Random r = new Random();

        if (r.nextBoolean() ) {
            nr = (byte) (r.nextInt(9) + 1);
            if (!unique() ) {
                nr = -1;
            }
        }
        return nr;
    }

    public boolean completeBlock() {
        return false; //TODO Return true, if all numbers 1-9 are present
    }

    // Checks for duplicate numbers in the block
    public boolean unique() { //FIXME
        for (int r = 0; r < squares.length; r++) {
            for (int c = 0; c < squares[r].length; c++) {

                if (squares[r][c] != null) {
                    for (int r1 = 0; r1 < squares.length; r1++) {
                        for (int c1 = 0; c1 < squares[r1].length; c1++) {

                            if (squares[r][c] == squares[r1][c1] && !(r == r1 || c == c1) ) { //FIXME feil her!
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder block = new StringBuilder();
        byte counter = 0;

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

    /*
     * Array[][] containing all squares in a 3x3 area
     * Should be able to represent a board with 9 objects
     * Should check if all the numbers in the block, are unique
     */
}
