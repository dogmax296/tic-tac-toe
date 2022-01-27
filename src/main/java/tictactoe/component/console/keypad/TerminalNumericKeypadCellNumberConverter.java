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

package tictactoe.component.console.keypad;

import tictactoe.component.console.CellNumberConverter;
import tictactoe.model.game.Cell;

import static java.lang.String.format;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public final class TerminalNumericKeypadCellNumberConverter implements CellNumberConverter {

    @Override
    public Cell toCell(final char number) {

        if (number >= '1' && number <= '9') {
            final int val = number - '0' - 1;
            return new Cell(val / 3, val % 3);
        } else {
            throw new IllegalArgumentException(
                    format("Number parameter must be between '1' and '9'! Current values is '%s', " + number)
            );
        }
    }

    @Override
    public char toNumber(final Cell cell) {
        if (cell.getRow() >= 0 && cell.getRow() <= 2 && cell.getColl() >= 0 && cell.getColl() <= 2) {
            return (char) ('0' + (cell.getRow() * 3 + cell.getColl() + 1));
        } else {
            throw new IllegalArgumentException(
                    format(
                            "Row and Col indexes must be between 0 and 2! Current row is %S, current col is %S",
                            cell.getRow(), cell.getColl()
                    )
            );
        }
    }
}
