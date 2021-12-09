package sudoku.board;

import sudoku.gui.Interface;

import java.util.Arrays;

public class Board {

    public static final int LEN = 3;
    public static final int LEN_TOT = LEN * LEN;

    private Block[][] board;

    public Board() {
        board = new Block[3][3];

        //Creates i objects of 3x3 Squares
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                board[r][c] = new Block(true);
            }
        }
    }

    /**
     * Checks if the game is finished
     * @return boolean - Returns true if the board is complete
     */

    public boolean isFinished() { //TODO Test

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

    public boolean completeHorizontal(int r) { //TODO Test

        for (int i = 0; i < board[r].length; i++) {
            if (board[r][i].completeHorizontal(r) != null) {
                for (int j = 0; j < board[r].length; j++) {
                    Square[] h1 = board[r][j].completeHorizontal(r);
                    Square[] h2 = board[r][j+1].completeHorizontal(r);
                    for (int h = 0; h < h1.length; h++) {
                        for (int k = 0; k < h1.length; k++) {
                            if (h1[h] != h2[k]) { //FIXME

                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     *
     * @return boolean - Returns true if all the numbers in a vertical line are unique
     */

    public boolean completeVertical(int n) { //TODO
        return false;
    }

    public Block[][] getBoard() {
        return board;
    }

    @Override
    public String toString() {
        StringBuilder all = new StringBuilder();

        for (Block[] r : board) {
            for (Block b : r) {
                all.append(b);
            }
            //all.append("\n");
        }
        return all.toString();
    }
}
