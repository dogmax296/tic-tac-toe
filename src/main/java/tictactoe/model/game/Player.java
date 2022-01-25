package tictactoe.model.game;

import tictactoe.component.Move;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public final class Player {
    private final Sign sign;
    private final Move move;

    public Player(final Sign sign, final Move move) {
        this.sign = sign;
        this.move = move;
    }

    public Sign getSign() {
        return sign;
    }

    public void makeMove(final GameTable gametable) {
        move.make(gametable, sign);
    }

    @Override
    public String toString() {
        return "'" + sign + "'";
    }
}
