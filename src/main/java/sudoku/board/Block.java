package sudoku.board;

import sudoku.control.SquareHandler;

import java.util.Random;

import static sudoku.board.Board.LEN;
import static sudoku.board.Board.LEN_TOT;

/*
 * Array[][] containing all squares in a 3x3 area
 * Should be able to represent a board with 9 objects
 * Should check if all the numbers in the block, are unique
 */

public class Block { //TODO Tests

    private Square[][] squares;

    /**
     * Constructs a block with 9 squares, randomly generates a number
     * @param generate If true, generates random numbers
     */
    public Block(boolean generate, int row, int col, Board board) {
        squares = new Square[LEN][LEN];
        row *= LEN; col *= LEN;

        for (int r = 0; r < squares.length; r++) {
            for (int c = 0; c < squares[r].length; c++) {
                int rowNr = r + row, colNr = c + col, nr = 0;
                if (generate) {
                    nr = generateNr(rowNr, colNr, board);
                }
                squares[r][c] = new SquareHandler(nr, rowNr, colNr);
            }
        }
    }

    /**
     * Generates a random number between 1-9 if a Random boolean is true.
     * If the number already exists in the block, the new number is tossed
     * @return int
     */
    public int generateNr(int row, int col, Board board) { //TODO also check all the number in each horizontal and verical direction!
        int nr = 0;
        Random r = new Random();

        if (r.nextBoolean() ) {
            nr = r.nextInt(LEN_TOT) + 1;
            if (exist(nr) || Utils.existHorizontally(board, nr, row) || Utils.existVertically(board, nr, col) ) {
                nr = 0;
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

        for (int i = 1; i <= LEN_TOT; i++) {
            if (!exist(i) ) {
                complete = false;
            }
        }
        return complete;
    }

    /**
     * Check if a horizontal row has unique numbers
     * @param n Index of the horizontal row
     * @return Square[] - Returns the array if all numbers are unique, else null
     */
    public Square[] completeHorizontal(int n) { //TODO Test

        Square[] horizontal = new Square[LEN];

        for (int r = 0; r < squares[n].length-1; r++) {
            for (int c = r+1; c < squares[n].length; c++) {
                if (existHorizontally(0, n) || squares[n][r].getNr() == squares[n][c].getNr() ) {
                    return null;
                }
                horizontal[r] = squares[n][r];
            }
        }
        return horizontal;
    }

    /**
     * Check if a vertical row has unique numbers
     * @param n Index of the vertical row
     * @return Square[] - Returns the array if all numbers are unique, else null
     */
    public Square[] completeVertical(int n) { //TODO Test

        Square[] vertical = new Square[LEN];

        for (int r = 0; r < squares[n].length-1; r++) {
            for (int c = r+1; c < squares[n].length; c++) {
                if (existVertically(0, n) || squares[r][n].getNr() == squares[c][n].getNr() ) {
                    return null;
                }
                vertical[r] = squares[r][n];
            }
        }
        return vertical;
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

    /**
     * Checks if the spesified nr exists in the spesified row
     * @param nr The value the method check against
     * @param row Which row to be checked {0, 1, 2}
     * @return - True if the number exists int the row
     */
    public boolean existHorizontally(int nr, int row) { //TODO Test

        for (Square s : squares[row]) {
            if (s.getNr() == nr) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the spesified nr exists in the spesified column
     * @param nr The value the method check against
     * @param col Which column to be checked {0, 1, 2}
     * @return - True if the number exists int the column
     */
    public boolean existVertically(int nr, int col) { //TODO Test

        for (Square[] square : squares) {
            if (square[col].getNr() == nr) {
                return true;
            }
        }
        return false;
    }

    /**
     * Fills the block with the first unused numbers
     */
    @Deprecated
    public void addAll() {
        for (int i = 1; i <= LEN_TOT; i++) {
            if (!exist(i) ) {
                addNumber(i);
            }
        }
    }

    /**
     * Adds a single number to the first empty square
     * @param nr a number between 1-9
     */
    @Deprecated
    public void addNumber(int nr) {
        for (Square[] r : squares) {
            for (Square c : r) {
                if (c.getNr() == 0) {
                    c.setNr(nr);
                    return;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder block = new StringBuilder();

        for (Square[] r : squares) {
            for (Square s : r) {
                block.append(s.printSquare() );
            }
            block.append("\n");
        }
        block.append("\n");
        return block.toString();
    }

    public Square[][] getSquares() {
        return squares;
    }

    public void setSquares(Square[][] squares) {
        this.squares = squares;
    }

}
