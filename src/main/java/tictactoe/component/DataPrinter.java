package tictactoe.component;

import tictactoe.model.GameTable;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public interface DataPrinter {

    void printInfoMessage(String message);
    void printErrorMessage(String message);
    void printMappingTable();
    void printGameTable(final GameTable gametable);

}
