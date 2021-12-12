package sudoku.gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SquareGUI extends Rectangle {

    private static final int SQUARE_SIZE = 30;

    private final Rectangle SQUARE;
    private final String ID;
    private Color background = Color.gray(0.7);
    private Color border = Color.gray(0);

    public SquareGUI(int row, int col) {
        SQUARE = new Rectangle(SQUARE_SIZE, SQUARE_SIZE, background);
        ID = row + ";" + col;
        SQUARE.setId(ID);
        SQUARE.setStroke(border); //TODO Thicker border between each block
    }

    @Override
    public String toString() {
        return "Square[ID=" + ID +
                ", Length=" + SQUARE_SIZE +
                ", Background colour=" + background +
                ", Border colour=" + border + "]";
    }

    public Rectangle getSQUARE() {
        return SQUARE;
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
