package tictactoe.component.strategy;

import tictactoe.component.ComputerMoveStrategy;
import tictactoe.model.game.Cell;
import tictactoe.model.game.GameTable;
import tictactoe.model.game.Sign;

import java.util.Random;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public class RandomComputerMoveStrategy implements ComputerMoveStrategy {

    @Override
    public boolean tryToMakeMove(final GameTable gameTable, final Sign sign) {
        final Cell[] emptyCells = new Cell[9];
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final Cell cell = new Cell(i, j);
                if (gameTable.isEmpty(cell)) {
                    emptyCells[count++] = cell;
                }
            }
        }
        if (count > 0) {
            final Cell randomCell = emptyCells[new Random().nextInt(count)];
            gameTable.setSign(randomCell, sign);
            return true;
        } else {
            return false;
        }
    }
}
