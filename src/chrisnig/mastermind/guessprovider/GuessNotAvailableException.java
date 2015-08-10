package chrisnig.mastermind.guessprovider;

public class GuessNotAvailableException extends Exception {

	private static final long serialVersionUID = 9078761770344599961L;

	GuessNotAvailableException(Throwable cause) {
		super("Could not make a guess!", cause);
	}
}
