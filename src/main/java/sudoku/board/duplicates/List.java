package sudoku.board.duplicates;

import sudoku.control.SquareHandler;

import java.util.ArrayList;

public class List {

    private ArrayList<Duplicate> list;

    public List() {
        list = new ArrayList<>();
    }

    public void add(Duplicate dupe) {
        list.add(dupe);
    }

    public int size() {
        return list.size();
    }
}
