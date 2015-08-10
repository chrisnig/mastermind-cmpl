package chrisnig.mastermind.guessprovider;

import java.util.ArrayList;

import chrisnig.mastermind.game.GuessResult;

public abstract class GuessProvider {
	protected ArrayList<GuessResult> guesses = new ArrayList<GuessResult>();
	
	public abstract int[] getGuess() throws GuessNotAvailableException;
	
	public void addGuessResult(GuessResult guessResult) {
		this.guesses.add(guessResult);
	}
}
