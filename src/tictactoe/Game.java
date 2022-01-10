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

package tictactoe;

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

    private final DrawVerifier drawVerifier;

    public Game(final DataPrinter dataPrinter,
                final ComputerMove computerMove,
                final UserMove userMove,
                final WinnerVerifier winnerVerifier,
                final DrawVerifier drawVerifier
    ) {
        this.dataPrinter = dataPrinter;
        this.computerMove = computerMove;
        this.userMove = userMove;
        this.winnerVerifier = winnerVerifier;
        this.drawVerifier = drawVerifier;
    }

    public void play() {
        System.out.println("Use the following mapping table to specify a cell using numbers from 1 to 9:");
        dataPrinter.printMappingTable();
        final GameTable gametable = new GameTable();
        if (new Random().nextBoolean()) {
            computerMove.make(gametable);
            dataPrinter.printGameTable(gametable);
        }
        while (true) {
            userMove.make(gametable);
            dataPrinter.printGameTable(gametable);
            if (winnerVerifier.isUserWin(gametable)) {
                System.out.println("YOU WIN!");
                break;
            }
            if (drawVerifier.isDraw(gametable)) {
                System.out.println("SORRY, DRAW!");
                break;
            }
            computerMove.make(gametable);
            dataPrinter.printGameTable(gametable);
            if (winnerVerifier.isComputerWin(gametable)) {
                System.out.println("COMPUTER WIN!");
                break;
            }
            if (drawVerifier.isDraw(gametable)) {
                System.out.println("SORRY, DRAW!");
                break;
            }

        }
        System.out.println("GAME OVER");
    }

}
