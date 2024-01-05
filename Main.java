package demo;

public class Main {
	public static void main(String[] args) {
		TicTacToeModel model = new TicTacToeModel();
		TicTacToeView view = new TicTacToeView(model);

		view.playGame();
	}
}
