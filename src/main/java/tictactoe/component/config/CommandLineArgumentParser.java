package tictactoe.component.config;

import tictactoe.model.config.Level;
import tictactoe.model.config.PlayerType;
import tictactoe.model.config.UserInterface;

import static java.lang.String.format;
import static tictactoe.model.config.Level.*;
import static tictactoe.model.config.PlayerType.*;
import static tictactoe.model.config.UserInterface.*;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public class CommandLineArgumentParser {

    final String[] args;

    public CommandLineArgumentParser(final String[] args) {
        this.args = args;
    }

    public CommandLineArguments parse() {
        PlayerType player1Type = null;
        PlayerType player2Type = null;
        UserInterface userInterface = null;
        Level level = null;

        for (final String arg : args) {
            if (USER.name().equalsIgnoreCase(arg) || COMPUTER.name().equalsIgnoreCase(arg)) {
                if (player1Type == null) {
                    player1Type = PlayerType.valueOf(arg.toUpperCase());

                } else if (player2Type == null) {
                    player2Type = PlayerType.valueOf(arg.toUpperCase());
                } else {
                    System.err.printf(
                            "Invalid command line arguments: '%s', because player types already set: player1Type='%s', player2Type='%s'!%n",
                            arg, player1Type, player2Type
                    );
                }
            } else if (GUI.name().equalsIgnoreCase(arg) || CONSOLE.name().equalsIgnoreCase(arg)) {
                if (userInterface == null) {
                    userInterface = UserInterface.valueOf(arg.toUpperCase());
                } else {
                    System.err.printf(
                            "Invalid command line arguments: '%s', because user interface is already set: '%s'!%n",
                            arg, userInterface
                    );
                }

            } else if(LEVEL1.name().equalsIgnoreCase(arg) ||
                    LEVEL2.name().equalsIgnoreCase(arg) ||
                    LEVEL3.name().equalsIgnoreCase(arg)){
                if(level == null){
                    level = Level.valueOf(arg.toUpperCase());
                } else {
                    System.err.printf(
                            "Invalid command line arguments: '%s', because the game level is already set: '%s'!%n",
                            arg, level
                    );
                }

            }else {
                System.err.printf(
                        "Unsupported command line argument: '%s'%n",
                        arg);
            }
        }


        if(level == null){
            level = LEVEL3;
        }
        if (userInterface == null) {
            userInterface = CONSOLE;
        }
        if (player1Type == null) {
            return new CommandLineArguments(USER, COMPUTER, userInterface, level);
        } else if (player2Type == null) {
            return new CommandLineArguments(USER, player1Type, userInterface, level);
        } else {
            return new CommandLineArguments(player1Type, player2Type, userInterface, level);
        }

    }

    public static class CommandLineArguments {
        private final PlayerType player1Type;
        private final PlayerType player2Type;
        private final UserInterface userInterface;
        private final Level level;

        private CommandLineArguments(final PlayerType player1Type,
                                     final PlayerType player2Type,
                                     final UserInterface userInterface, final Level level) {
            this.player1Type = player1Type;
            this.player2Type = player2Type;
            this.userInterface = userInterface;
            this.level = level;
        }

        public PlayerType getPlayer1Type() {
            return player1Type;
        }

        public PlayerType getPlayer2Type() {
            return player2Type;
        }

        public UserInterface getUserInterface() {
            return userInterface;
        }

        public Level getGameLevel() {
            return level;
        }
    }
}
