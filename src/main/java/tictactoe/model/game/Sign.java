package tictactoe.model.game;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public enum Sign {
    X,
    O,
    EMPTY;

    public Sign oppositeSign(){
        if (this == X){
            return O;
        } else if(this == O){
            return X;
        } else {
            throw new IllegalArgumentException("Empty value doesn't have any opposite one!");
        }
    }

    @Override
    public String toString() {
        if(this == EMPTY){
            return " ";
        } else {
            return name();
        }
    }
}
