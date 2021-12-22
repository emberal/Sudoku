package sudoku.board;

import sudoku.control.SquareHandler;

public class Board {

    public static final int LEN = 3;
    public static final int LEN_TOT = LEN * LEN;

    private Block[][] board;

    public Board(boolean generate) {
        board = new Block[LEN][LEN];

        //Creates i objects of 3x3 Squares
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                board[r][c] = new Block(generate, r, c, this);
            }
        }
    }

    /**
     * Checks if the game is finished
     * @return boolean - Returns true if the board is complete
     */

    public boolean isFinished() {

        boolean finished = true;

        int i = 0;
        while (i < LEN_TOT && finished) {
            if (!completeHorizontal(i) ) {
                finished = false;
            }
            if (!completeVertical(i) ) {
                finished = false;
            }
            i++;
        }

        return finished;
    }

    /**
     *
     * @return boolean - Returns true if all the numbers in a horizontal line are unique
     */

    public boolean completeHorizontal(int r) {

        int bRow = r / LEN, sRow = r % LEN;

        for (int i = 0; i < board[bRow].length; i++) {
            if (board[bRow][i].completeHorizontal(sRow) != null) {
                for (int j = 0; j < board[bRow].length - 1; j++) {

                    Square[] h1 = board[bRow][j].completeHorizontal(sRow);
                    Square[] h2 = board[bRow][j + 1].completeHorizontal(sRow);
                    if (!(h1 == null || h2 == null) ) {

                        //Compares the values in both arrays
                        for (int h = 0; h < h1.length - 1; h++) {
                            for (int k = h + 1; k < h1.length; k++) {
                                if (h1[h] == h2[k]) {
                                    return false;
                                }
                            }
                        }
                    }
                    else {
                        return false;
                    }
                }
            }
            else {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @return boolean - Returns true if all the numbers in a vertical line are unique
     */

    public boolean completeVertical(int v) {

        int bVer = v / LEN, sVer = v % LEN;

        for (int i = 0; i < board[bVer].length; i++) {
            if (board[bVer][i].completeVertical(sVer) != null) {
                for (int j = 0; j < board[bVer].length - 1; j++) {

                    Square[] h1 = board[j][bVer].completeVertical(sVer);
                    Square[] h2 = board[j + 1][bVer].completeVertical(sVer);
                    if (!(h1 == null || h2 == null) ) {

                        //Compares the values in both arrays
                        for (int h = 0; h < h1.length - 1; h++) {
                            for (int k = h + 1; k < h1.length; k++) {
                                if (h1[h] == h2[k]) {
                                    return false;
                                }
                            }
                        }
                    }
                    else {
                        return false;
                    }
                }
            }
            else {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param nr
     * @param row
     * @return
     */
    public boolean existHorizontally(int nr, int row) { //TODO Test

        for (Block b : board[row / LEN]) {
            if (b != null && b.existHorizontally(nr, row % LEN)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param nr
     * @param col
     * @return
     */
    public boolean existVertically(int nr, int col) { //TODO Test

        for (Block[] b : board) {
            if (b[col / LEN] != null && b[col / LEN].existVertically(nr, col % LEN)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if there are duplicate numbers in a row, and return the first SquareHandler int the row
     * @param sqr The object the method checks against
     * @return - The SquareHandler objekt, or null, if there are no duplicates
     */
    public SquareHandler dupeHorizontal(SquareHandler sqr) { //TODO Test

        int row = sqr.getRow();

        if (existHorizontally(sqr.getNr(), row)) {
            for (Block b : board[row / LEN]) {
                for (int c = 0; c < b.getSquares().length; c++) {
                    if (b.getSquares()[row % LEN][c] != sqr && b.getSquares()[row % LEN][c].getNr() == sqr.getNr()) {
                        return b.getSquares()[row % LEN][c];
                    }
                }
            }
        }
        return null;
    }

    /**
     * Checks if there are duplicate numbers in a column, and return the first SquareHandler int the column
     * @param sqr The objekt the method checks against
     * @return - The SquareHandler objekt, or null, if there are no duplicates
     */
    public SquareHandler dupeVertical(SquareHandler sqr) { //TODO Test

        int col = sqr.getCol();

        if (existVertically(sqr.getNr(), col)) {
            for (Block[] b : board) {
                for (int c = 0; c < b[col / LEN].getSquares().length; c++) {
                    if (b[col / LEN].getSquares()[c][col % LEN] != sqr && b[col / LEN].getSquares()[c][col % LEN].getNr() == sqr.getNr()) {
                        return b[col / LEN].getSquares()[c][col % LEN];
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (Block[] r : board) {
            for (int b = 0; b < board.length; b++) {

                for (Block block : r) {
                    for (int s = 0; s < board.length; s++) {
                        str.append(block.getSquares()[b][s].printSquare() );
                    }
                    str.append(" ");
                }
                str.append("\n");
            }
            str.append("\n");
        }

        return str.toString();
    }

    public Block[][] getBoard() {
        return board;
    }

    public void setBoard(Block[][] board) {
        this.board = board;
    }

}
