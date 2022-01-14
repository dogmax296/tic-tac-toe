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

import tictactoe.model.Cell;
import tictactoe.model.GameTable;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public class WinnerVerifier {
    public boolean isUserWin(final GameTable gametable) {
        return isWinner(gametable, 'X');
    }

    public boolean isComputerWin(final GameTable gametable) {

        return isWinner(gametable, '0');
    }

    private boolean isWinner(final GameTable gametable, final char symbol) {
        return isWinByRows(gametable, symbol) ||
                isWinByCols(gametable, symbol) ||
                isWinByMainDiagonal(gametable, symbol) ||
                isWinBySecondDiagonal(gametable, symbol);
    }


    private boolean isWinBySecondDiagonal(final GameTable gameTable, final char symbol) {
        return gameTable.getSign(new Cell(0, 2)) == gameTable.getSign(new Cell(1, 1)) &&
                gameTable.getSign(new Cell(1, 1)) == gameTable.getSign(new Cell(2, 0)) &&
                gameTable.getSign(new Cell(2, 0)) == symbol;
    }

    private boolean isWinByMainDiagonal(final GameTable gameTable, final char symbol) {
        return gameTable.getSign(new Cell(0, 0)) == gameTable.getSign(new Cell(1, 1)) &&
                gameTable.getSign(new Cell(1, 1)) == gameTable.getSign(new Cell(2, 2)) &&
                gameTable.getSign(new Cell(2, 2)) == symbol;
    }

    private boolean isWinByRows(final GameTable gameTable, final char symbol) {
        for (int i = 0; i < 3; i++) {
            if (gameTable.getSign(new Cell(0, i)) == gameTable.getSign(new Cell(1, i)) &&
                    gameTable.getSign(new Cell(1, i)) == gameTable.getSign(new Cell(2, i)) &&
                    gameTable.getSign(new Cell(2, i)) == symbol) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinByCols(final GameTable gameTable, final char symbol) {
        for (int i = 0; i < 3; i++) {
            if (gameTable.getSign(new Cell(i, 0)) == gameTable.getSign(new Cell(i, 1)) &&
                    gameTable.getSign(new Cell(i, 1)) == gameTable.getSign(new Cell(i, 2)) &&
                    gameTable.getSign(new Cell(i, 2)) == symbol) {
                return true;
            }
        }
        return false;
    }
}
