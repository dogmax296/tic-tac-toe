package tictactoe;

import tictactoe.component.*;
import tictactoe.component.config.CommandLineArgumentParser;
import tictactoe.component.console.CellNumberConverter;
import tictactoe.component.console.ConsoleDataPrinter;
import tictactoe.component.console.ConsoleGameOverHandler;
import tictactoe.component.console.ConsoleUserInputReader;
import tictactoe.component.console.keypad.DesktopNumericKeypadCellNumberConverter;
import tictactoe.component.swing.GameWindow;
import tictactoe.model.config.Level;
import tictactoe.model.game.Player;
import tictactoe.model.config.PlayerType;
import tictactoe.model.config.UserInterface;

import static tictactoe.component.config.CommandLineArgumentParser.*;
import static tictactoe.model.config.PlayerType.*;
import static tictactoe.model.game.Sign.*;
import static tictactoe.model.config.UserInterface.*;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public class GameFactory {

    private final PlayerType player1Type;
    private final PlayerType player2Type;
    private final UserInterface userInterface;
    private final Level level;

    public GameFactory(final String[] args) {
        final CommandLineArguments commandLineArguments = new CommandLineArgumentParser(args).parse();
        player1Type = commandLineArguments.getPlayer1Type();
        player2Type = commandLineArguments.getPlayer2Type();
        userInterface = commandLineArguments.getUserInterface();
        level = commandLineArguments.getGameLevel();
    }

    public Game create() {
        final DataPrinter dataPrinter;
        final UserInputReader userInputReader;
        final GameOverHandler gameOverHandler;
        if (userInterface == GUI) {
            final GameWindow gameWindow = new GameWindow();
            dataPrinter = gameWindow;
            userInputReader = gameWindow;
            gameOverHandler = gameWindow;
        } else {
            final CellNumberConverter cellNumberConverter = new DesktopNumericKeypadCellNumberConverter();
            dataPrinter = new ConsoleDataPrinter(cellNumberConverter);
            userInputReader = new ConsoleUserInputReader(cellNumberConverter, dataPrinter);
            gameOverHandler = new ConsoleGameOverHandler(dataPrinter);
        }

        Player player1;
        if (this.player1Type == USER) {
            player1 = new Player(X, new UserMove(userInputReader, dataPrinter));
        } else {
            player1 = new Player(X, new ComputerMove(level.getStrategies()));
        }

        Player player2;
        if (this.player2Type == USER) {
            player2 = new Player(O, new UserMove(userInputReader, dataPrinter));
        } else {
            player2 = new Player(O, new ComputerMove(level.getStrategies()));
        }

        final boolean canSecondPlayerMakeFirstMove = this.player1Type != this.player2Type;
        return new Game(
                gameOverHandler,
                dataPrinter,
                player1,
                player2,
                new WinnerVerifier(),
                new CellVerifier(),
                canSecondPlayerMakeFirstMove
        );
    }
}
