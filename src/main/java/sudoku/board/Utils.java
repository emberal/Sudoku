package sudoku.board;

import static sudoku.board.Board.LEN;
import static sudoku.board.Board.LEN_TOT;

public abstract class Utils {

    public static boolean existHorizontally(Board board, int nr, int row) {

        for (int i = 0; i < LEN; i++) {
            if (board.getBoard()[row / LEN][i] != null && board.getBoard()[row / LEN][i].existHorizontally(nr, row % LEN) ) {
                return true;
            }
        }
        return false;
    }

    public static boolean existVertically(Board board, int nr, int col) {

        for (int i = 0; i < LEN; i++) {
            if (board.getBoard()[i][col / LEN] != null && board.getBoard()[i][col / LEN].existVertically(nr, col % LEN) ) {
                return true;
            }
        }
        return false;
    }

}
