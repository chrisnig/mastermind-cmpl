package chrisnig.mastermind.guessprovider;

import chrisnig.mastermind.Util;
import chrisnig.mastermind.game.Board;

public class RandomGuessProvider extends GuessProvider {

	@Override
	public int[] getGuess() {
		int[] colors = new int[Board.numberOfColors];
		for (int i = 0; i < Board.numberOfColors; ++i) {
			colors[i] = Board.availableColors[Util.randomWithRange(0, Board.availableColors.length-1)];
		}
		return colors;
	}
}
