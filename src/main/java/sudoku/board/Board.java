package sudoku.board;

import sudoku.gui.Interface;

public class Board {

    public static final int LEN = 3;
    public static final int LEN_TOT = LEN*LEN;

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
