package sudoku.control;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import sudoku.board.Board;
import sudoku.board.Square;
import sudoku.gui.Interface;
import sudoku.gui.SquareGUI;

import static sudoku.board.Board.LEN;

/**
 * TODO Move label and connected values and methods to this file as attributes
 */

public class SquareHandler extends Square {

    private static final String S = "   ";

    private SquareGUI square;
    private Label value; //TODO set different colour to the numbers placed by the game
    private int row, col;
    private Board board;

    public SquareHandler(int nr, int row, int col, Board board) {
        super(nr);
        this.row = row; this.col = col;
        this.board = board;
        square = new SquareGUI(row, col);
        value = new Label(S);
        Interface.addToBoard(square.getSQUARE(), col, row);
        updateValue(nr);
        Interface.addToBoard(value, col, row);
        square.getSQUARE().setOnMouseClicked(this::onClick);
    }

    @Override
    public String toString() {
        return "SquareHandler{" + square +
                ", value=" + super.getNr() +
                ", row=" + row +
                ", col=" + col + '}';
    }

    @Override
    public String printSquare() {
        String s = "";
        if (col % 3 == 0) {
            s += row + " ";
        }

        return s + super.printSquare();
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

        if (nr != 0) {
            s += Integer.toString(nr);
        }
        value.setText(s);

        value.setDisable(true); //Disables the numbers, so they don't block the squares
        value.setOpacity(1); //Sets the opacity back to 0%
        if (!isEditable()) {
            value.setStyle("-fx-text-fill: Blue");
        }

        return true;
    }

    private void checkSquares(int nr) {
        if (board.completeHorizontal(row)) { //TODO Sometimes works, not at 1st selection but 2nd
            System.out.println("Horizantal complete, at row " + row);
            //Highlight row green
        }
        if (board.completeVertical(col)) { //TODO Doesn't work
            System.out.println("Vertical complete, at column " + col);
            //Highlight column green
        }
        if (board.getBoard()[row/LEN][col/LEN].completeBlock()) { //TODO Doesn't work
            System.out.println("Block " + row/LEN + ";" + col/LEN + " complete");
            //Highlight block green
        }
        if (board.existHorizontally(nr, row)) { //Works
            System.out.println("Duplicates at row " + row);
            board.getDuplicateHorizontally(this);
            //Mark dupelicates with red font
        }
        if (board.existVertically(nr, col)) { //Works
            System.out.println("Duplicates at column " + col);
            board.getDuplicateVertically(this);
            //Mark dupelicates with red font
        }
        System.out.println("----------");
    }

    @Override
    public void setNr(int nr) {
        if (updateValue(nr) ) {
            checkSquares(nr);
            super.setNr(nr);
        }
    }

    public void setNr(String nr) {
        int n;
        try {
            n = Integer.parseInt(nr);
        }
        catch (NumberFormatException e) {
            n = -1;
            System.out.println("Not a Number!");
        }
        if (n > -1) {
            setNr(n);
        }
    }

    /**
     * Starts the KeyHandler if the square is editable
     * @param e MouseEvent
     * @return - True if the square was edited
     */
    public boolean onClick(MouseEvent e) { //TODO Remove event after button press, or escape button is pressed
        System.out.println(this);
        if (isEditable() ) {
            Interface.SCENE.setOnKeyPressed(key -> {

                if (key.getCode().isDigitKey() ) {
                    setNr(key.getText() );
                }
                key.consume();
            });
        }
        return isEditable();
    }

    public Label getValue() {
        return value;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
