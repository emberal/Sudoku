package sudoku.board;

import sudoku.gui.Interface;

import java.util.Random;

import static sudoku.board.Board.LEN;
import static sudoku.board.Board.LEN_TOT;

/*
 * Array[][] containing all squares in a 3x3 area
 * Should be able to represent a board with 9 objects
 * Should check if all the numbers in the block, are unique
 */

public class Block { //TODO Tests

    private static int rowNr = 0, colNr = 0;

    private Square[][] squares;

    /**
     * Constructs a block with 9 squares, randomly generates a number
     * @param generate If true, generates random numbers
     */

    public Block(boolean generate) {
        squares = new Square[LEN][LEN];

        for (int r = 0; r < squares.length; r++) {
            for (int c = 0; c < squares[r].length; c++) {
                if (generate) {
                    squares[r][c] = new Square(generateNr() );
                }
                else {
                    squares[r][c] = new Square(-1);
                }
                Interface.createSquare(r + rowNr, c + colNr);
                Interface.updateValue(squares[r][c].getNr(), r + rowNr, c + colNr);
                adjustPos(r, c); //Updates rowNr and colNr
            }
        }
    }

    /**
     * Increases column by 3 for each block created
     * Increases row by 3 if three blocks have been created, and resets column count
     * @param row
     * @param col
     */

    private static void adjustPos(int row, int col) { //TODO change to something better!!!
        if (row % LEN == 2 && col % LEN == 2) {
            if (colNr == LEN_TOT-LEN) {
                rowNr += LEN;
                colNr = 0;
            }
            else {
                colNr += LEN;
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
            nr = r.nextInt(LEN_TOT) + 1;
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

    public Square[] completeHorizontal(int n) { //TODO change to check parameter

        Square[] hori = new Square[LEN];
        boolean complete = false;

        for (Square[] row : squares) {
            if (row != null && row[0].getNr() != 0) {
                for (int i = 1; i < hori.length; i++) {
                    if (row[i] != row[i - 1] && row[i].getNr() != 0) {
                        complete = true;
                    }
                    else {
                        complete = false;
                        break;
                    }
                }
            }
            if (complete) {
                System.arraycopy(row, 0, hori, 0, hori.length);
                return hori;
            }
        }
        return null;
    }

    /**
     * Check if a vertical row has unique numbers
     * @param n Index of the vertical row
     * @return Square[] - Returns the array if all numbers are unique, else null
     */

    public Square[] completeVertical(int n) { //TODO Test

        Square[] vert = new Square[LEN];
        boolean complete = false;

        for (int c = 0; c < squares.length; c++) {
            for (int r = 1; r < vert.length; r++) {
                if (squares[r] != null && squares[r-1][0].getNr() != 0) {
                    complete = squares[r][c] != squares[r - 1][c] && squares[r][c].getNr() != 0;
                }
            }
        }
        if (complete) {
            for (int i = 0; i < vert.length; i++) {
                vert[i] = squares[i][0];
            }
            return vert;
        }
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

    public void setSquares(Square[][] squares) {
        this.squares = squares;
    }

}
