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

import tictactoe.model.GameTable;

import java.util.Random;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public final class Game {

    private final DataPrinter dataPrinter;

    private final ComputerMove computerMove;

    private final UserMove userMove;

    private final WinnerVerifier winnerVerifier;

    private final CellVerifier cellVerifier;

    public Game(final DataPrinter dataPrinter,
                final ComputerMove computerMove,
                final UserMove userMove,
                final WinnerVerifier winnerVerifier,
                final CellVerifier cellVerifier
    ) {
        this.dataPrinter = dataPrinter;
        this.computerMove = computerMove;
        this.userMove = userMove;
        this.winnerVerifier = winnerVerifier;
        this.cellVerifier = cellVerifier;
    }

    public void play() {
        System.out.println("Use the following mapping table to specify a cell using numbers from 1 to 9:");
        dataPrinter.printMappingTable();
        final GameTable gametable = new GameTable();
        if (new Random().nextBoolean()) {
            computerMove.make(gametable);
            dataPrinter.printGameTable(gametable);
        }

        final Move[] moves = {userMove, computerMove};
        while (true) {
            boolean gameOver = false;
            for (final Move move : moves) {
                move.make(gametable);
                dataPrinter.printGameTable(gametable);
                if (move instanceof UserMove) {
                    if (winnerVerifier.isUserWin(gametable)) {
                        System.out.println("YOU WIN!");
                        printGameOver();
                        return;
                    }
                } else {
                    if (winnerVerifier.isComputerWin(gametable)) {
                        System.out.println("COMPUTER WIN!");
                        printGameOver();
                        return;
                    }
                }

                if (cellVerifier.allCellsFilled(gametable)) {
                    System.out.println("SORRY, DRAW!");
                    printGameOver();
                    return;
                }
            }
        }
    }

    private void printGameOver() {
        System.out.println("GAME OVER");
    }

}
