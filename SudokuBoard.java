package sudoku_game.board;

import sudoku_game.exceptions.InvalidValueException;

public class SudokuBoard {
    private int[][] grid;

    public SudokuBoard() {
        grid = new int[9][9]; // Initialize an empty board
    }

    public int getCellValue(int row, int col) {
        return grid[row][col];
    }

    public void setCellValue(int row, int col, int value) throws InvalidValueException {
        if (value < 1 || value > 9 || !isValidMove(row, col, value)) {
            throw new InvalidValueException("Invalid move.");
        }
        grid[row][col] = value;
    }

    public boolean isValidMove(int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == value || grid[i][col] == value) {
                return false;
            }
        }

        int boxRow = row / 3 * 3;
        int boxCol = col / 3 * 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (grid[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBoardComplete() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void displayBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
