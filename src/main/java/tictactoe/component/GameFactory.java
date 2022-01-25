package tictactoe.component;

import tictactoe.component.console.ConsoleDataPrinter;
import tictactoe.component.console.ConsoleUserInputReader;
import tictactoe.component.keypad.DesktopNumericKeypadCellNumberConverter;
import tictactoe.component.swing.GameWindow;
import tictactoe.model.Player;
import tictactoe.model.PlayerType;
import tictactoe.model.UserInterface;

import static tictactoe.component.CommandLineArgumentParser.*;
import static tictactoe.model.PlayerType.*;
import static tictactoe.model.Sign.*;
import static tictactoe.model.UserInterface.*;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public class GameFactory {

    private PlayerType player1Type;
    private PlayerType player2Type;
    private final UserInterface userInterface;

    public GameFactory(final String[] args) {
        final CommandLineArguments commandLineArguments = new CommandLineArgumentParser(args).parse();
        player1Type = commandLineArguments.getPlayer1Type();
        player2Type = commandLineArguments.getPlayer2Type();
        userInterface = commandLineArguments.getUserInterface();
    }

    public Game create() {
        final DataPrinter dataPrinter;
        final UserInputReader userInputReader;

        if (userInterface == GUI) {
            final GameWindow gameWindow = new GameWindow();
            dataPrinter = gameWindow;
            userInputReader = gameWindow;
        } else {
            final CellNumberConverter cellNumberConverter = new DesktopNumericKeypadCellNumberConverter();
            dataPrinter = new ConsoleDataPrinter(cellNumberConverter);
            userInputReader = new ConsoleUserInputReader(cellNumberConverter, dataPrinter);
        }

        Player player1 = null;
        if (this.player1Type == USER) {
            player1 = new Player(X, new UserMove(userInputReader, dataPrinter));
        } else {
            player1 = new Player(X, new ComputerMove());
        }

        Player player2 = null;
        if (this.player2Type == USER) {
            player2 = new Player(O, new UserMove(userInputReader, dataPrinter));
        } else {
            player2 = new Player(O, new ComputerMove());
        }

        final boolean canSecondPlayerMakeFirstMove = this.player1Type != this.player2Type;
        return new Game(
                dataPrinter,
                player1,
                player2,
                new WinnerVerifier(),
                new CellVerifier(),
                canSecondPlayerMakeFirstMove
        );
    }
}
