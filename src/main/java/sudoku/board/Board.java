package sudoku.board;

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

        boolean complete = true;
        int bRow = r / LEN, sRow = r % LEN;

        for (int i = 0; i < board[bRow].length; i++) {
            if (board[bRow][i].completeHorizontal(sRow) != null) {
                for (int j = 0; j < board[bRow].length - 1; j++) {

                    Square[] h1 = board[bRow][j].completeHorizontal(sRow);
                    Square[] h2 = board[bRow][j + 1].completeHorizontal(sRow);
                    if (!(h1 == null || h2 == null)) {
                        //Compares the values in both arrays
                        for (int h = 0; h < h1.length - 1; h++) {
                            for (int k = h + 1; k < h1.length && !complete; k++) {
                                if (h1[h] == h2[k]) {
                                    return false;
                                }
                                else {
                                    complete = true;
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
                complete = false;
            }
        }
        return complete;
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

    public void setBoard(Block[][] board) {
        this.board = board;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (Block[] r : board) {
            for (Block b : r) {

                for (Square[] sr : b.getSquares() ) {
                    for (Square s : sr) {
                        str.append(s.printSquare() );
                    }
                    str.append(" ");
                }
                str.append("\n");
            }
            str.append("\n");
        }

        return str.toString();
    }

}
