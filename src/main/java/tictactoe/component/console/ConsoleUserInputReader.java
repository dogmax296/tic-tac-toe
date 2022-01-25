package tictactoe.component.console;

import tictactoe.component.CellNumberConverter;
import tictactoe.component.DataPrinter;
import tictactoe.component.UserInputReader;
import tictactoe.model.Cell;

import java.util.Scanner;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public class ConsoleUserInputReader implements UserInputReader {

    private final CellNumberConverter cellNumberConverter;

    private final DataPrinter dataPrinter;

    public ConsoleUserInputReader(final CellNumberConverter cellNumberConverter, final DataPrinter dataPrinter) {
        this.cellNumberConverter = cellNumberConverter;
        this.dataPrinter = dataPrinter;
    }

    @Override
    public Cell getUserInput() {
        while (true) {
            dataPrinter.printInfoMessage("Please, enter the number from 1 to 9!");
            final String userInput = new Scanner(System.in).nextLine();
            if (userInput.length() == 1) {
                final char ch = userInput.charAt(0);
                if (ch >= '1' && ch <= '9') {
                    return cellNumberConverter.toCell(ch);
                } else {
                    dataPrinter.printInfoMessage("Wrong Symbol!");
                }
            } else {
                dataPrinter.printInfoMessage("Use single character");
            }
        }

    }
}
