package sudoku;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sudoku.board.Block;
import sudoku.board.Board;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        //TODO Everything!
        stage.setTitle("Sudoku");
        BorderPane pane = new BorderPane();

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        //stage.show();

        test();
    }

    private void test() {
        Board board = new Board();
        System.out.println(board);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
