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

import tictactoe.component.*;
import tictactoe.component.keypad.DesktopNumericKeypadCellNumberConverter;
import tictactoe.model.Player;

import static tictactoe.model.Sign.*;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public final class Launcher {
    public static void main(final String[] args) {
        final CellNumberConverter cellNumberConverter = new DesktopNumericKeypadCellNumberConverter();

        final Game game = new Game(
                new DataPrinter(cellNumberConverter),
                new Player(X,new UserMove(cellNumberConverter)),
                new Player(O,new ComputerMove()),
                new WinnerVerifier(),
                new CellVerifier(),
                true);
        game.play();
    }
}
