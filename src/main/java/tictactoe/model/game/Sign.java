package tictactoe.model.game;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public enum Sign {
    X,
    O,
    EMPTY;

    @Override
    public String toString() {
        if(this == EMPTY){
            return " ";
        } else {
            return name();
        }
    }
}
