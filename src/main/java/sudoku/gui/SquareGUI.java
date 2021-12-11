package sudoku.gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SquareGUI extends Rectangle {

    private static final int SQUARE_SIZE = 30;

    private Color background = Color.gray(0.7);
    private Color border = Color.gray(0);
    private Rectangle square;
    private final String ID;

    public SquareGUI(int row, int col) {
        square = new Rectangle(SQUARE_SIZE, SQUARE_SIZE, background);
        ID = row + ";" + col;
        square.setId(ID);
        square.setStroke(border); //TODO Thicker border between each block
    }

    @Override
    public String toString() {
        return "Square[ID=" + ID +
                ", Length=" + SQUARE_SIZE +
                ", Background colour=" + background +
                ", Border colour=" + border + "]";
    }

    public Rectangle getSquare() {
        return square;
    }

    public String getID() {
        return ID;
    }

    public void setBackground(Color background) {
        this.background = background;
    }

    public void setBorder(Color border) {
        this.border = border;
    }
}
