package sudoku_game.solver;

import sudoku_game.board.SudokuBoard;

public interface Solver {
    boolean solve(SudokuBoard board);
}
