package chrisnig.mastermind.game;

import java.util.Arrays;
import java.util.Collections;

public class GuessResult {
	private int[] guess;
	private String[] result;
	
	public GuessResult(int[] guess, String[] result) {
		this.guess = guess;
		this.result = result;
	}
	
	public String toString() {
		return "Guess: " + Arrays.toString(this.guess) + ", Result: " + Arrays.toString(this.result);
	}
	
	public int getWhitePins() {
		return Collections.frequency(Arrays.asList(this.result), "W");
	}
	
	public int getBlackPins() {
		return Collections.frequency(Arrays.asList(this.result), "B");
	}
	
	public int[] getGuess() {
		return this.guess;
	}
	
	public String[] getResult() {
		return this.result;
	}
}
