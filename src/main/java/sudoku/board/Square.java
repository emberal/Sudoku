package sudoku.board;

public class Square {

    private int nr;
    private final boolean EDITABLE; //Numbers set by the game, should not be editable by the player

    public Square(int nr) {

        if (nr < 0 || nr > 8) {
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
            this.nr = nr; //TODO call method to change value on label
        }
        else {
            System.out.println("Not editable!");
        }
    }

    public int getNr() {
        return nr;
    }

}
