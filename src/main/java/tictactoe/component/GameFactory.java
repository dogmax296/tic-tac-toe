package tictactoe.component;

import tictactoe.component.keypad.DesktopNumericKeypadCellNumberConverter;
import tictactoe.model.Player;
import tictactoe.model.PlayerType;

import static tictactoe.model.Sign.O;
import static tictactoe.model.Sign.X;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public class GameFactory {

    private final PlayerType player1Type = PlayerType.USER;
    private final PlayerType player2Type = PlayerType.COMPUTER;

    public GameFactory(final String[] args) {
        // TODO
    }

    public Game create() {
        final CellNumberConverter cellNumberConverter = new DesktopNumericKeypadCellNumberConverter();
        return new Game(
                new DataPrinter(cellNumberConverter),
                // FIXME
                new Player(X, new UserMove(cellNumberConverter)),
                new Player(O, new ComputerMove()),
                new WinnerVerifier(),
                new CellVerifier(),
                true
        );
    }
}
