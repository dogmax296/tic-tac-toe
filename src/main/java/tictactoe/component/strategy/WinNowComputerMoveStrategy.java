package tictactoe.component.strategy;

import tictactoe.component.ComputerMoveStrategy;
import tictactoe.model.game.Cell;
import tictactoe.model.game.GameTable;
import tictactoe.model.game.Sign;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public class WinNowComputerMoveStrategy implements ComputerMoveStrategy {

    @Override
    public boolean tryToMakeMove(final GameTable gametable, final Sign sign) {
        return tryToMakeMoveToRows(gametable, sign) ||
                tryToMakeMoveToCols(gametable, sign) ||
                tryToMakeMoveToMainDiagonal(gametable, sign) ||
                tryToMakeMoveToSecondDiagonal(gametable, sign);

    }

    private boolean tryToMakeMoveToRows(final GameTable gametable, final Sign sign) {
        for (int i = 0; i < 3; i++) {
            if (tryToMakeMoveUsingLambda((k, j) -> new Cell(k, j), gametable, sign, i)) {
                return true;
            }
        }
        return false;

    }

    private boolean tryToMakeMoveToCols(final GameTable gametable, final Sign sign) {
        for (int i = 0; i < 3; i++) {
            if (tryToMakeMoveUsingLambda((k, j) -> new Cell(j, k), gametable, sign, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean tryToMakeMoveToMainDiagonal(final GameTable gametable, final Sign sign) {
        return tryToMakeMoveUsingLambda((k, j) -> new Cell(j, j), gametable, sign, -1);
    }

    private boolean tryToMakeMoveToSecondDiagonal(final GameTable gametable, final Sign sign) {
        return tryToMakeMoveUsingLambda((k, j) -> new Cell(j, 2 - j), gametable, sign, -1);
    }

    private boolean tryToMakeMoveUsingLambda(final Lambda lambda, final GameTable gametable, final Sign sign, final int i) {
        int countEmptyCells = 0;
        int countSignCells = 0;
        Cell lastEmptyCell = null;
        for (int j = 0; j < 3; j++) {
            final Cell cell = lambda.calculate(i, j);
            if (gametable.isEmpty(cell)) {
                lastEmptyCell = cell;
                countEmptyCells++;
            } else if (gametable.getSign(cell) == sign) {
                countSignCells++;
            } else {
                break;
            }
        }
        if (countEmptyCells == 1 && countSignCells == 2) {
            gametable.setSign(lastEmptyCell, sign);
            return true;
        }
        return false;
    }

    @FunctionalInterface
    private interface Lambda {
        Cell calculate(int k, int j);
    }


}
