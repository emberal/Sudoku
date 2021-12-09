package sudoku.control;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import sudoku.board.Square;
import sudoku.gui.Interface;

import static sudoku.board.Board.LEN_TOT;

/**
 * TODO Move label and connected values and methods to this file as attributes
 */

public class SquareHandler extends Square implements EventHandler<ActionEvent> { //TODO Check Interface

    private static final String S = "   ";
    private Label value;

    public SquareHandler(int nr) { //TODO Constructor
        super(nr);
        value = new Label(S + nr);
    }

    public boolean updateValue(int v, int row, int col) {

        if (v > 9 || v < 0) {
            return false;
        }

        String s = S;

        if (v == 0) {
            s += " ";
        }
        else {
            s += Integer.toString(v);
        }
        value.setText(s);

        value.setDisable(true); //Disables the numbers, so they don't block the squares
        value.setOpacity(1); //Sets the opacity back to 0%

        Interface.addToBoard(value, col, row);
        return true;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

    }

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
        Interface.SCENE.addEventHandler(KeyEvent.KEY_PRESSED, SquareHandler::getKey);
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
