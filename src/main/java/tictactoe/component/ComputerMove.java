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

import java.util.Random;

import static java.lang.String.format;
import static tictactoe.model.game.Sign.EMPTY;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public class ComputerMove implements Move{

    @Override
    public void make(final GameTable gametable, Sign sign) {
        final Cell[] emptyCells = new Cell[9];
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final Cell cell = new Cell(i,j);
                if(gametable.isEmpty(cell)){
                    emptyCells[count++] = cell;
                }
            }
        }
        if(count > 0){
            final Cell randomCell = emptyCells[new Random().nextInt(count)];
            gametable.setSign(randomCell,sign);
        } else {
            throw new IllegalArgumentException("No empty cell for computer move");
        }


    }
}
