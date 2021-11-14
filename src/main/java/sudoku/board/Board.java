package sudoku.board;

public class Board {

    private Block[] board;

    public Board() {
        board = new Block[9];

        //Creates i objects of 3x3 Squares
        for (int i = 0; i < board.length; i++) {
            board[i] = new Block();
        }
    }
}
