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

import tictactoe.model.game.Cell;
import tictactoe.model.game.GameTable;
import tictactoe.model.game.Sign;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public class UserMove implements Move{

    private final UserInputReader userInputReader;
    private DataPrinter dataprinter;

    public UserMove(final UserInputReader userInputReader, final DataPrinter dataprinter) {
        this.userInputReader = userInputReader;
        this.dataprinter = dataprinter;
    }

    @Override
    public void make(final GameTable gametable, final Sign sign) {
        while (true) {
            final Cell cell = userInputReader.getUserInput();
            if (gametable.isEmpty(cell)) {
                gametable.setSign(cell, sign);
                return;
            } else {
                dataprinter.printErrorMessage("Can't make a move, because the cell is not free! Try again!");
            }
        }
    }

}
