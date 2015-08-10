package chrisnig.mastermind.game;

public class NumberGuessesExceededException extends Exception {

	private static final long serialVersionUID = -2194944571153429473L;

	NumberGuessesExceededException() {
		super("The maximum number of guesses has been exceeded!");
	}
}
