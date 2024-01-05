package demo;

import java.util.Scanner;

public class TicTacToeView {
	private TicTacToeModel model;

	public TicTacToeView(TicTacToeModel model) {
		this.model = model;
	}

	public void displayBoard() {
		char[][] board = model.getBoard();
		System.out.println("  0 1 2");
		for (int i = 0; i < 3; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void playGame() {
		Scanner scanner = new Scanner(System.in);

		for (int turn = 0; turn < 9; turn++) {
			displayBoard();
			System.out.println("Player " + model.getCurrentPlayer() + ", enter your move (row and column): ");
			int row = scanner.nextInt();
			int col = scanner.nextInt();

			if (model.makeMove(row, col)) {
				if (model.checkWin()) {
					displayBoard();
					System.out.println("Player " + model.getCurrentPlayer() + " wins!");
					break;
				} else if (turn == 8) {
					displayBoard();
					System.out.println("It's a draw!");
				}
			} else {
				System.out.println("Invalid move. Try again.");
				turn--; // Retry the current turn
			}
		}

		scanner.close();
	}
}
