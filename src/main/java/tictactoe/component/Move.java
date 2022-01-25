package tictactoe.component;

import tictactoe.model.GameTable;
import tictactoe.model.Sign;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public interface Move {
    void make(GameTable gametable, Sign sign);
}
