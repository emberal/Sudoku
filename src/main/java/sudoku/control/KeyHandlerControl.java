package sudoku.control;

import sudoku.gui.Interface;

public class KeyHandlerControl {

    public KeyHandlerControl(SquareHandler squareHandler) {
        Interface.SCENE.setOnKeyPressed(key -> {

            if (key.getCode().isDigitKey() ) {
                squareHandler.setNr(key.getText() );
            }
            key.consume();
        });
    }

}
