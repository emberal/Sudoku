package sudoku.board;

public class Block {

    private Square[][] squares;

    public Block() {
        squares = new Square[3][3];

        for (int r = 0; r < squares.length; r++) {
            for (int k = 0; k < squares[r].length; k++) {
                squares[r][k] = new Square();
            }
        }
    }

    public boolean completeBlock() {
        return false; //TODO Return true, if all numbers 1-9 are present
    }

    /*
     * Array[][] containing all squares in a 3x3 area
     * Should be able to represent a board with 9 objects
     * Should check if all the numbers in the block, are unique
     */
}
