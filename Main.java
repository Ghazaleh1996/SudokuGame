package sudoku_game.main;

import sudoku_game.game.SudokuGame;
import sudoku_game.generator.EasySudokuGenerator;
import sudoku_game.generator.PuzzleGenerator;
import sudoku_game.solver.BacktrackingSolver;
import sudoku_game.solver.Solver;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PuzzleGenerator generator = new EasySudokuGenerator();
        Solver solver = new BacktrackingSolver();
        SudokuGame game = new SudokuGame(generator, solver);

        game.startGame();

        Scanner scanner = new Scanner(System.in);
        while (!game.board.isBoardComplete()) {
            System.out.print("Enter row, column, and value (1-9): ");
            int row = scanner.nextInt() - 1;  // Convert to 0-indexed
            int col = scanner.nextInt() - 1;  // Convert to 0-indexed
            int value = scanner.nextInt();

            game.makeMove(row, col, value);

            if (game.board.isBoardComplete()) {
                System.out.println("You have completed the puzzle!");
                break;
            }
        }

        System.out.print("Do you want to solve the puzzle automatically? (yes/no): ");
        String solve = scanner.next();
        if (solve.equalsIgnoreCase("yes")) {
            game.solveGame();
        }

        scanner.close();
    }
}
