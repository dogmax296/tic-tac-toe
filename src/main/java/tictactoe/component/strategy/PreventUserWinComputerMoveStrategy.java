package tictactoe.component.strategy;

import tictactoe.model.game.Sign;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public class PreventUserWinComputerMoveStrategy extends AbstractComputerMoveStrategy {

    @Override
    protected Sign getFindSign(final Sign moveSign) {
        return moveSign.oppositeSign();
    }
}
