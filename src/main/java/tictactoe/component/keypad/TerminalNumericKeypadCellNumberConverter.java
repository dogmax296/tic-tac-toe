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

package tictactoe.component.keypad;

import tictactoe.component.CellNumberConverter;
import tictactoe.model.Cell;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public final class TerminalNumericKeypadCellNumberConverter implements CellNumberConverter {

    @Override
    public Cell toCell(final char number) {
        final int val = number - '0' - 1;
        return new Cell(val / 3, val % 3);

    }

    @Override
    public char toNumber(final Cell cell) {
        return (char) ('0' + (cell.getRow() * 3 + cell.getColl() + 1));
    }
}
