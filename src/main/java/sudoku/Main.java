package sudoku;

import javafx.application.Application;
import javafx.stage.Stage;
import sudoku.board.Board;
import sudoku.gui.Interface;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Board board = new Board(true);
        System.out.println(board);

        Interface.start(stage);
    }
}
