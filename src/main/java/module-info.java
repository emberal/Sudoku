module sudoku.sudoku {
    requires javafx.controls;
    requires javafx.fxml;


    opens sudoku.sudoku to javafx.fxml;
    exports sudoku.sudoku;
}