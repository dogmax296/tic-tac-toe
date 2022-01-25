package tictactoe.component;

import tictactoe.component.console.ConsoleDataPrinter;
import tictactoe.component.console.ConsoleUserInputReader;
import tictactoe.component.keypad.DesktopNumericKeypadCellNumberConverter;
import tictactoe.model.Player;
import tictactoe.model.PlayerType;

import static tictactoe.component.CommandLineArgumentParser.*;
import static tictactoe.model.PlayerType.*;
import static tictactoe.model.Sign.*;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public class GameFactory {

    private PlayerType player1Type;
    private PlayerType player2Type;

    public GameFactory(final String[] args) {
        final PlayerTypes playerTypes = new CommandLineArgumentParser(args).parse();
        this.player1Type = playerTypes.getPlayer1Type();
        this.player2Type = playerTypes.getPlayer2Type();
    }

    public Game create() {
        final CellNumberConverter cellNumberConverter = new DesktopNumericKeypadCellNumberConverter();
        final DataPrinter dataPrinter = new ConsoleDataPrinter(cellNumberConverter);
        final UserInputReader userInputReader = new ConsoleUserInputReader(cellNumberConverter, dataPrinter);

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
