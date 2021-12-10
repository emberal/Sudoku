package sudoku.control;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sudoku.board.Square;
import sudoku.gui.Interface;

import static sudoku.board.Board.LEN_TOT;

/**
 * TODO Move label and connected values and methods to this file as attributes
 */

public class SquareHandler extends Square implements EventHandler<ActionEvent> { //TODO Check Interface

    private static final String S = "   ";
    private static final int SQUARE_SIZE = 30;

    private Rectangle square;
    private Label value;
    private int row, col;
    private final String ID = row + ";" + col;

    public SquareHandler(int nr, int row, int col) {
        super(nr);
        initiateSquare();
        value = new Label(S + nr);
        this.row = row;
        this.col = col;
    }

    /**
     *
     */

    public void initiateSquare() {
        square = new Rectangle(SQUARE_SIZE, SQUARE_SIZE, Color.gray(0.7) );
        square.setStroke(Color.gray(0) );
        square.setOnMouseClicked(SquareHandler::onClick);

        //BOARD.add(square, col, row); //TODO
    }

    /**
     *
     * @param nr The new value, must be 0-9
     * @return - Returns false if the value is illegal, else return true
     */

    public boolean updateValue(int nr) {

        if (nr > 9 || nr < 0) {
            return false;
        }

        String s = S;

        if (nr == 0) {
            s += " ";
        }
        else {
            s += Integer.toString(nr);
        }
        value.setText(s);

        value.setDisable(true); //Disables the numbers, so they don't block the squares
        value.setOpacity(1); //Sets the opacity back to 0%

        Interface.addToBoard(value, col, row);
        return true;
    }

    @Override
    public void handle(ActionEvent actionEvent) { //TODO

    }

    /**
     *
     * @param nr
     */

    @Override
    public void setNr(int nr) {
        if (updateValue(nr) ) {
            super.setNr(nr);
        }
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
