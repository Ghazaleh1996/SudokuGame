package sudoku_game.generator;

import sudoku_game.board.SudokuBoard;

public class HardSudokuGenerator implements PuzzleGenerator {
    @Override
    public SudokuBoard generatePuzzle() {
        SudokuBoard board = new SudokuBoard();
        board.setCellValue(0, 1, 8);
        board.setCellValue(1, 3, 6);
        board.setCellValue(2, 5, 9);
        // Add more cells for a hard puzzle
        return board;
    }
}
