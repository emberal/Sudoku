package sudoku.control;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import sudoku.gui.Interface;

import static sudoku.board.Board.LEN_TOT;

/**
 * TODO Move label and connected values and methods to this file as attributes
 * TODO Rename class to ...?
 * TODO Constructor
 */

public class GameBoard {

    /**
     *
     * @param e
     * @return
     */

    public static int onClick(MouseEvent e) { //TODO handle returns
        System.out.println(e.getSource() );

        for (int r = 0; r < LEN_TOT; r++) {
            for (int c = 0; c < LEN_TOT; c++) {
                if (e.getSource().toString().contains(r + ";" + c) ) {
                    selectValue();
                }
            }
        }
        return 0;
    }

    /**
     *
     * @return
     */

    public static int selectValue() { //TODO handle returns
        Interface.SCENE.addEventHandler(KeyEvent.KEY_PRESSED, GameBoard::getKey);
        return 0;
    }

    /**
     *
     * @param key
     * @return
     */

    private static int getKey(KeyEvent key) { //TODO handle returns

        if (key.getCode().isDigitKey() ) {
            return key.getCode().getCode();
        }
        return 0;
    }

}
