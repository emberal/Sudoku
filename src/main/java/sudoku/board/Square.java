package sudoku.board;

public class Square {

    private byte nr;
    private boolean editable; //Numbers set by the game, should not be editable by the player

    public Square() {
        //TODO place random numbers on the board, find out how many...
    }

    public void setNr(byte nr) {
        this.nr = nr;
    }

    public byte getNr() {
        return nr;
    }

    /*
     * Creates a single square object
     * Containing byte number between 1-9
     */


}
