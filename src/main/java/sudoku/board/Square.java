package sudoku.board;

public class Square {

    private int nr;
    private final boolean EDITABLE; //Numbers set by the game, should not be editable by the player

    public Square(int nr) {

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

    public void setNr(int nr) {
        if (EDITABLE) {
            this.nr = nr;
        }
        else {
            System.out.println("Not editable!");
        }
    }

    public int getNr() {
        return nr;
    }

}
