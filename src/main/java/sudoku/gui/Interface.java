package sudoku.gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import sudoku.control.GameBoard;

public abstract class Interface {

    private static final BorderPane PANE = new BorderPane();
    private static final GridPane BOARD = new GridPane();
    public static final Scene SCENE = new Scene(PANE, 1000, 500); //TODO window size

    /**
     * Sets up the scene
     * @param stage Window
     */

    public static void start(Stage stage) {
        stage.setTitle("Sudoku");
        stage.setScene(SCENE);
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

    public static void createSquare(int row, int col) { //TODO Move to Square class?
        final int SIZE = 30;
        Rectangle square = new Rectangle(SIZE, SIZE, Color.gray(0.7) );
        square.setStroke(Color.gray(0) );
        square.setId(row + ";" + col); //Gives each square a unique ID

        square.setOnMouseClicked(GameBoard::onClick); //TODO Move to different method?

        BOARD.add(square, col, row);
    }

    /**
     * Sets the value in the label on the GameBoard
     *
     * @param v The value
     * @param row Position across x-axis
     * @param col Position across y-axis
     * @return boolean - If the method was successfull return true
     */

    public static boolean updateValue(int v, int row, int col) {

        if (v > 9 || v < 0) {
            return false;
        }

        Label value = new Label();
        String s = "   ";

        if (v == 0) {
            s += " ";
        }
        else {
            s += Integer.toString(v);
        }
        value.setText(s);

        value.setDisable(true); //Disables the numbers, so they don't block the squares
        value.setOpacity(1); //Sets the opacity back to 0%

        BOARD.add(value,col,row);
        return true;
    }

    /**
     *
     */

    public static void updateAllValues() { //TODO Nesseccary?

    }

}
