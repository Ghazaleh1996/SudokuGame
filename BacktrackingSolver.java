package sudoku_game.solver;

import sudoku_game.board.SudokuBoard;
import sudoku_game.exceptions.InvalidValueException;

public class BacktrackingSolver implements Solver {
    @Override
    public boolean solve(SudokuBoard board) {
        return solveSudoku(board, 0, 0);
    }

    private boolean solveSudoku(SudokuBoard board, int row, int col) {
        if (row == 9) {
            return true; // Solved the entire board
        }

        if (board.getCellValue(row, col) != 0) {
            return solveSudoku(board, col == 8 ? row + 1 : row, (col + 1) % 9);
        }

        for (int num = 1; num <= 9; num++) {
            if (board.isValidMove(row, col, num)) {
                try {
                    board.setCellValue(row, col, num);
                    if (solveSudoku(board, col == 8 ? row + 1 : row, (col + 1) % 9)) {
                        return true;
                    }
                    board.setCellValue(row, col, 0); // Reset on backtrack
                } catch (InvalidValueException e) {
                    e.printStackTrace(); // Shouldn't happen here
                }
            }
        }
        return false; // No valid solution
    }
}
