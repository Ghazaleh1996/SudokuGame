package sudoku_game.game;

import sudoku_game.board.SudokuBoard;
import sudoku_game.generator.PuzzleGenerator;
import sudoku_game.solver.Solver;
import sudoku_game.exceptions.InvalidValueException;

public class SudokuGame {
    private SudokuBoard board;
    private Solver solver;
    private PuzzleGenerator generator;

    public SudokuGame(PuzzleGenerator generator, Solver solver) {
        this.generator = generator;
        this.solver = solver;
        this.board = generator.generatePuzzle();
    }

    public void startGame() {
        board = generator.generatePuzzle();
        board.displayBoard();
    }

    public void solveGame() {
        if (solver.solve(board)) {
            System.out.println("Puzzle solved!");
        } else {
            System.out.println("No solution exists.");
        }
        board.displayBoard();
    }

    public void makeMove(int row, int col, int value) {
        try {
            board.setCellValue(row, col, value);
        } catch (InvalidValueException e) {
            System.out.println(e.getMessage());
        }
        board.displayBoard();
    }
}
