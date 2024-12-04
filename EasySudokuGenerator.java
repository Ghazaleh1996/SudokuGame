package sudoku_game.generator;

import sudoku_game.board.SudokuBoard;

public class EasySudokuGenerator implements PuzzleGenerator {
    @Override
    public SudokuBoard generatePuzzle() {
        SudokuBoard board = new SudokuBoard();
        board.setCellValue(0, 0, 5);
        board.setCellValue(1, 1, 3);
        board.setCellValue(2, 2, 6);
        // Add more cells for an easy puzzle
        return board;
    }
}
