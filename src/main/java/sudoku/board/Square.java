package sudoku.board;

/* Creates a single square object
 * Containing byte number between 1-9
 */

public class Square {

    private byte nr;
    private final boolean EDITABLE; //Numbers set by the game, should not be editable by the player

    public Square(byte nr) {

        if (nr != -1) {
            this.nr = nr;
            EDITABLE = false;
        }
        else {
            EDITABLE = true;
        }
        //TODO place random numbers on the board, 2 - 5 (various difficulty?)
    }

    @Override
    public String toString() {
        String stringNr;

        if (nr > 0) {
            stringNr = Integer.toString(nr);
        }
        else {
            stringNr = " ";
        }

        return "[" + stringNr + "]";
    }

    public void setNr(byte nr) {
        this.nr = nr;
    }

    public byte getNr() {
        return nr;
    }

}
