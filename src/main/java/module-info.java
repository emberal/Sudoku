module sudoku.board {
    requires javafx.controls;
    requires javafx.fxml;


    opens sudoku.board to javafx.fxml;
    exports sudoku;
}