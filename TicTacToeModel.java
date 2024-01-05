package demo;

import java.util.Arrays;

public class TicTacToeModel {
	private char[][] board;
	private char currentPlayer;

	public TicTacToeModel() {
		board = new char[3][3];
		currentPlayer = 'X';
		initializeBoard();
	}

	private void initializeBoard() {
		for (char[] row : board) {
			Arrays.fill(row, ' ');
		}
	}

	public char getCurrentPlayer() {
		return currentPlayer;
	}

	public char[][] getBoard() {
		return board;
	}

	public boolean makeMove(int row, int col) {
		if (isValidMove(row, col)) {
			board[row][col] = currentPlayer;
			currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
			return true;
		}
		return false;
	}

	public boolean checkWin() {
		return checkRows() || checkColumns() || checkDiagonals();
	}

	private boolean isValidMove(int row, int col) {
		return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
	}

	private boolean checkRows() {
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
				return true;
			}
		}
		return false;
	}

	private boolean checkColumns() {
		for (int j = 0; j < 3; j++) {
			if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != ' ') {
				return true;
			}
		}
		return false;
	}

	private boolean checkDiagonals() {
		return (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ')
				|| (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ');
	}
}
