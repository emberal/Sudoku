package sudoku.board.duplicates;

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

    public ArrayList<Duplicate> getList() {
        return list;
    }

    @Override
    public String toString(){
        return list.toString();
    }
}

