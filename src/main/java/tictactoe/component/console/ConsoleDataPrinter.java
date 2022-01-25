package tictactoe.component.console;

import tictactoe.component.CellNumberConverter;
import tictactoe.component.DataPrinter;
import tictactoe.model.Cell;
import tictactoe.model.GameTable;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public class ConsoleDataPrinter implements DataPrinter{

    private final CellNumberConverter cellNumberConverter;

    public ConsoleDataPrinter(final CellNumberConverter cellNumberConverter) {
        this.cellNumberConverter = cellNumberConverter;
    }

    @Override
    public void printInfoMessage(final String message) {
        System.out.println(message);
    }

    @Override
    public void printErrorMessage(final String message) {
        System.err.println(message);
    }

    @Override
    public void printMappingTable() {
        print((i,j) -> String.valueOf(cellNumberConverter.toNumber(new Cell(i, j))));
    }

    @Override
    public void printGameTable(final GameTable gametable) {
        print((i,j) -> String.valueOf(gametable.getSign(new Cell(i, j))));
    }

    private void print(final Lambda lambda) {
        for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + lambda.getValue(i,j) + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }

    @FunctionalInterface
    private interface Lambda {
        String getValue(int i, int j);
    }
}
