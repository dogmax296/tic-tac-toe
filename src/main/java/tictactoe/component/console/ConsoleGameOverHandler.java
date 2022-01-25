package tictactoe.component.console;

import tictactoe.component.DataPrinter;
import tictactoe.component.GameOverHandler;

import java.util.Scanner;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public class ConsoleGameOverHandler implements GameOverHandler {
    private final DataPrinter dataPrinter;

    public ConsoleGameOverHandler(final DataPrinter dataPrinter) {
        this.dataPrinter = dataPrinter;
    }

    @Override
    public void gameOver() {
        dataPrinter.printInfoMessage("GAME OVER!");
        new Scanner(System.in).nextLine();
    }
}
