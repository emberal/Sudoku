package sudoku.board;

public class Board {

    private Block[][] board;

    public Board() {
        board = new Block[3][3];

        //Creates i objects of 3x3 Squares
        for (int r = 0; r < board.length; r++) {
            for (int k = 0; k < board[r].length; k++) {
                board[r][k] = new Block(true);
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
