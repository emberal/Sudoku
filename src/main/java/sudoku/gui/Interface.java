package sudoku.gui;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

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
     * Sets up the GameBoard
     */
    private static void gameBoard() { //TODO
        PANE.setLeft(BOARD);
        BOARD.setPadding(new Insets(30) );
    }

    /**
     * Adds a node to the GridPane
     * @param node Node to be added
     * @param col Column position
     * @param row Row position
     */
    public static void addToBoard(Node node, int col, int row) {
        BOARD.add(node, col, row);
    }

}
