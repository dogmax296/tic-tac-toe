package tictactoe.component.strategy;

import tictactoe.model.game.Sign;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public class PreventUserWinComputerMoveStrategy extends AbstractComputerMoveStrategy {

    public PreventUserWinComputerMoveStrategy() {
        super(1);
    }

    @Override
    protected Sign getFindSign(final Sign moveSign) {
        return moveSign.oppositeSign();
    }

}
