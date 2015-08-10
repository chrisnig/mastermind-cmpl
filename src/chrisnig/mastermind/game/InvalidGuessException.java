package chrisnig.mastermind.game;

public class InvalidGuessException extends Exception {

	private static final long serialVersionUID = -7011610022335900069L;

	InvalidGuessException(String message) {
		super(message);
	}
}
