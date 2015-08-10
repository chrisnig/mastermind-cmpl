package chrisnig.mastermind.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Mastermind {
	public static int maximumGuesses = 12;
	
	private Board board = new Board();
	private ArrayList<GuessResult> guesses = new ArrayList<GuessResult>();
	private boolean solved = false;
	
	public Mastermind() {
		
	}
	
	public GuessResult guess(int[] guess) throws GameAlreadySolvedException, NumberGuessesExceededException, InvalidGuessException {
		if (this.solved == true) {
			throw new GameAlreadySolvedException();
		}
		
		if (this.guesses.size() >= Mastermind.maximumGuesses) {
			throw new NumberGuessesExceededException();
		}
		
		String[] result = this.board.guess(guess);
		GuessResult guessResult = new GuessResult(guess, result);
		
		this.guesses.add(guessResult);
		this.solved = this.checkSolved();
		
		return guessResult;
	}
	
	public GuessResult[] getGuesses() {
		return (GuessResult[])this.guesses.toArray();
	}
	
	public boolean isSolved() {
		return this.solved;
	}
	
	private boolean checkSolved() {
		if (this.guesses.size() == 0) {
			return false;
		}
		
		GuessResult latest = this.guesses.get(this.guesses.size() - 1);
		
		return Collections.frequency(Arrays.asList(latest.getResult()), "B") == 4;
	}

}
