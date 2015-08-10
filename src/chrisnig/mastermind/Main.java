package chrisnig.mastermind;

import chrisnig.mastermind.game.GuessResult;
import chrisnig.mastermind.game.Mastermind;
import chrisnig.mastermind.guessprovider.CmplGuessProvider;
import chrisnig.mastermind.guessprovider.GuessProvider;

public class Main {
	public static void main (String[] args) throws Exception {
		Mastermind game = new Mastermind();
		
		GuessProvider guessProvider = new CmplGuessProvider();
		GuessResult result = null;
		
		for (int i = 0; i < Mastermind.maximumGuesses && !game.isSolved(); ++i) {
			result = game.guess(guessProvider.getGuess());
			guessProvider.addGuessResult(result);
			System.out.println(result.toString());
		}
		
		if (game.isSolved()) {
			System.out.println("The game is solved!");
		} else {
			System.out.println("No solution found within maximum number of guesses.");
		}
		
	}
}
