package sudoku.gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import sudoku.control.GameBoard;

import static sudoku.board.Board.LEN;
import static sudoku.board.Board.LEN_TOT;

public abstract class Interface {

    private static final BorderPane PANE = new BorderPane();
    private static final GridPane BOARD = new GridPane();

    private static int rowNr = 0, colNr = 0;

    /**
     * Sets up the scene
     * @param stage Window
     */

    public static void start(Stage stage) {
        stage.setTitle("Sudoku");
        Scene scene = new Scene(PANE, 1000, 500); //TODO window size
        stage.setScene(scene);
        stage.show();

        hbox();
        gameBoard();
    }

    /**
     * Menubuttons at the top of the stage
     */

    private static void hbox() { //TODO button methods
        HBox hbox = new HBox();
        PANE.setTop(hbox);

        MenuItem newGame = new MenuItem("New game");
        MenuItem exit = new MenuItem("Exit");
        MenuButton game = new MenuButton("Game", null, newGame, exit);

        MenuItem difficulty = new MenuItem("Difficulty");
        MenuButton settings = new MenuButton("Settings", null, difficulty);
        hbox.getChildren().addAll(game, settings);
    }

    /**
     *
     */

    private static void gameBoard() { //TODO
        PANE.setLeft(BOARD);
        BOARD.setPadding(new Insets(30));
    }

    /**
     * Creates a single square, at a spesific point, with a unique id
     * @param row Row number where the square will be created
     * @param col Column number where the square will be created
     */

    public static void createSquare(int row, int col) { //TODO print numbers on the board
        row += rowNr; col += colNr;
        final int SIZE = 30;
        Rectangle square = new Rectangle(SIZE, SIZE, Color.gray(0.7) );
        square.setStroke(Color.gray(0) );
        square.setId(row + ";" + col); //Gives each square a unique ID

        square.setOnMouseClicked(GameBoard::onClick);

        BOARD.add(square, col, row);

        // Increases column by 3 for each block created
        // Increases row by 3 if three blocks have been created, and resets column count
        if (row % LEN == 2 && col % LEN == 2 && colNr <= LEN_TOT) {
            if (colNr == LEN_TOT-LEN) {
                rowNr += LEN;
                colNr = 0;
            }
            else {
                colNr += LEN;
            }
        }
    }

}
