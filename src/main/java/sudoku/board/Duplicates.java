package sudoku.board;

import java.util.HashMap;

public abstract class Duplicates {

    /** K (id) = SquareGUI id
     *  V (value) = Square nr
     */

    private static HashMap<String, Integer> dupes = new HashMap<>();

    public static void add(String id, int nr) {
        dupes.put(id, nr);
    }

    public static boolean exists(int nr) {
        return dupes.containsValue(nr);
    }

    public static int nrOfDupes(int nr) {
        int tot = 0;
        for (int i = 0; i < dupes.size(); i++) {
            if (exists(nr)) {
                tot++;
            }
        }
        return tot;
    }

    public static boolean rm(String id, int nr) {
        return dupes.remove(id, nr);
    }

}
