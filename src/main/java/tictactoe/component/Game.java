/*
 * Copyright 2022 dogmax296
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package tictactoe.component;

import tictactoe.model.game.GameTable;
import tictactoe.model.game.Player;

import java.util.Random;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public final class Game {

    private final GameOverHandler gameOverHandler;

    private final DataPrinter dataPrinter;

    private final Player player1;

    private final Player player2;

    private final WinnerVerifier winnerVerifier;

    private final CellVerifier cellVerifier;

    private final boolean canSecondPlayerMakeFirstMove;

    public Game(final GameOverHandler gameOverHandler, final DataPrinter dataPrinter,
                final Player player1,
                final Player player2,
                final WinnerVerifier winnerVerifier,
                final CellVerifier cellVerifier, final boolean canSecondPlayerMakeFirstMove) {
        this.gameOverHandler = gameOverHandler;
        this.dataPrinter = dataPrinter;
        this.player1 = player1;
        this.player2 = player2;
        this.winnerVerifier = winnerVerifier;
        this.cellVerifier = cellVerifier;
        this.canSecondPlayerMakeFirstMove = canSecondPlayerMakeFirstMove;
    }

    public void play() {
        dataPrinter.printInstructions();
        final GameTable gametable = new GameTable();
       if (canSecondPlayerMakeFirstMove && new Random().nextBoolean()) {
            player2.makeMove(gametable);
            dataPrinter.printGameTable(gametable);
        }
        final Player[] players = {player1, player2};
        while (true) {
            for (final Player player : players) {
                player.makeMove(gametable);
                dataPrinter.printGameTable(gametable);
                if (winnerVerifier.isWinner(gametable, player)) {
                    dataPrinter.printInfoMessage(player + " WIN!");
                    gameOverHandler.gameOver();
                    return;
                }

                if (cellVerifier.allCellsFilled(gametable)) {
                    dataPrinter.printInfoMessage("SORRY, DRAW!");
                    gameOverHandler.gameOver();
                    return;
                }
            }

        }

    }

}
