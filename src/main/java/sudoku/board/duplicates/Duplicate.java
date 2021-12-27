package sudoku.board.duplicates;

import sudoku.control.SquareHandler;

import java.util.ArrayList;

public class Duplicate {

    private ArrayList<SquareHandler> dupe;

    public Duplicate() {
        dupe = new ArrayList<>();
    }

    public void add(SquareHandler s) {
        List list;
        if (isEmpty() ) {
            list = new List();
            list.add(this);
        }
        dupe.add(s);
    }

    public boolean exists(SquareHandler s) {
        return dupe.contains(s);
    }

    public int size() {
        return dupe.size();
    }

    public boolean rm(SquareHandler s) {
        return dupe.remove(s);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

}
