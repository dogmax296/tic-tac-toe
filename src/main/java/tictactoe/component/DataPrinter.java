package tictactoe.component;

import tictactoe.model.game.GameTable;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public interface DataPrinter {

    void printInstructions();
    void printInfoMessage(String message);
    void printErrorMessage(String message);
    void printGameTable(final GameTable gametable);

}
