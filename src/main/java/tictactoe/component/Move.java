package tictactoe.component;

import tictactoe.model.game.GameTable;
import tictactoe.model.game.Sign;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public interface Move {
    void make(GameTable gametable, Sign sign);
}
