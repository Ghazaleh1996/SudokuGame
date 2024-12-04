package sudoku_game.generator;

import sudoku_game.board.SudokuBoard;

public interface PuzzleGenerator {
    SudokuBoard generatePuzzle();
}
