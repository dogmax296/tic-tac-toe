package tictactoe.component;

import tictactoe.model.PlayerType;

import static tictactoe.model.PlayerType.COMPUTER;
import static tictactoe.model.PlayerType.USER;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public class CommandLineArgumentParser {

    final String[] args;

    public CommandLineArgumentParser(final String[] args) {
        this.args = args;
    }

    public PlayerTypes parse(){
        PlayerType player1Type = null;
        PlayerType player2Type = null;

        for (final String arg : args) {
            if (USER.name().equalsIgnoreCase(arg) || COMPUTER.name().equalsIgnoreCase(arg)) {
                if (player1Type == null) {
                    player1Type = PlayerType.valueOf(arg.toUpperCase());

                } else if (player2Type == null) {
                    player2Type = PlayerType.valueOf(arg.toUpperCase());
                } else {
                    System.err.println("Unsupported command line argument: '" + arg + "'");
                }
            } else {
                System.err.println("Unsupported command line argument: '" + arg + "'");
            }
        }

        if (player1Type == null) {
            return new PlayerTypes(USER,COMPUTER);
        } else if (player2Type == null) {
            return new PlayerTypes(USER,player1Type);
        } else {
            return new PlayerTypes(player1Type,player2Type);
        }

    }

    public static class PlayerTypes{
        private final PlayerType player1Type;
        private final PlayerType player2Type;

        private PlayerTypes(final PlayerType player1Type, final PlayerType player2Type) {
            this.player1Type = player1Type;
            this.player2Type = player2Type;
        }

        public PlayerType getPlayer1Type() {
            return player1Type;
        }

        public PlayerType getPlayer2Type() {
            return player2Type;
        }
    }
}
