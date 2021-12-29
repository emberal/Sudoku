package sudoku.board.duplicates;

import sudoku.control.SquareHandler;

import java.util.ArrayList;

public class Duplicate {

    private ArrayList<SquareHandler> dupe;
    private List list;

    public Duplicate() {
        dupe = new ArrayList<>();
    }

    public void add(SquareHandler s) {
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
        boolean rm = dupe.remove(s);
        if (isSingle()) {
            dupe.remove(0);
        }
        return rm;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isSingle() {
        return size() == 1;
    }

    public List getList() {
        return list;
    }

    @Override
    public String toString() {
        return dupe.toString();
    }

    public String getIDs() {
        StringBuilder s = new StringBuilder();
        for (SquareHandler sqr : dupe) {
            s.append(sqr.getId() ).append(", ");
        }
        return s.toString();
    }

}
